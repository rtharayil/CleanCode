### User Story: Flexible Notification System

---

#### **Title**: As a user, I want to receive notifications via multiple channels (e.g., email, SMS, push notifications) so that I can stay informed in a way that is most convenient for me.

---

#### **User Story**:
As a **user**,  
I want the system to send me notifications through my preferred channel (e.g., email, SMS, or push notifications),  
so that I can receive important updates in a way that suits my needs.

---

#### **Acceptance Criteria**:
1. **Notification Channels**:
   - The system should support sending notifications via **email**, **SMS**, and **push notifications**.
   - New notification channels (e.g., WhatsApp, Slack) can be added in the future without modifying the core `NotificationService`.

2. **Content Customization**:
   - The content of the notification should be customizable based on the channel.
     - **Email**: Supports rich text (HTML) and attachments.
     - **SMS**: Limited to plain text (160 characters).
     - **Push Notification**: Short text with optional actions or links.

3. **Flexibility**:
   - The `NotificationService` should not depend on specific notification channel implementations. Instead, it should depend on abstractions (e.g., interfaces).

4. **Extensibility**:
   - Adding a new notification channel (e.g., WhatsApp) should require minimal changes to the system.

5. **Error Handling**:
   - If a notification fails to send through one channel, the system should log the error and attempt to send it through another channel (fallback mechanism).

---

#### **Technical Requirements**:
1. **Abstraction**:
   - Define an interface `INotificationChannel` with a method `Send(NotificationMessage message)`.
   - Each notification channel (e.g., email, SMS, push) will implement this interface.

2. **Notification Message**:
   - Create a `NotificationMessage` class that contains:
     - `Content` (e.g., text, HTML).
     - `Metadata` (e.g., recipient, subject, priority).
     - `ChannelType` (e.g., email, SMS, push).

3. **Content Customization**:
   - Each channel implementation will handle the `NotificationMessage` differently based on the channel's requirements.

4. **Dependency Injection**:
   - Use dependency injection to inject the appropriate `INotificationChannel` implementation into the `NotificationService`.

---

#### **Example Workflow**:
1. A user triggers a notification (e.g., "Your appointment is confirmed").
2. The system determines the user's preferred notification channel(s).
3. The `NotificationService` sends the notification using the appropriate channel(s).
4. The content of the notification is formatted based on the channel:
   - **Email**: HTML content with a subject line.
   - **SMS**: Plain text with a character limit.
   - **Push Notification**: Short text with a call-to-action button.

---

#### **Example Code Implementation**:

##### 1. Define the `INotificationChannel` Interface:
```csharp
public interface INotificationChannel
{
    void Send(NotificationMessage message);
}
```

##### 2. Create the `NotificationMessage` Class:
```csharp
public class NotificationMessage
{
    public string Content { get; set; }
    public string Recipient { get; set; }
    public string Subject { get; set; }
    public string ChannelType { get; set; } // e.g., "Email", "SMS", "Push"
}
```

##### 3. Implement Notification Channels:
```csharp
// Email Channel
public class EmailChannel : INotificationChannel
{
    public void Send(NotificationMessage message)
    {
        Console.WriteLine($"Sending Email to {message.Recipient}: Subject: {message.Subject}, Content: {message.Content}");
    }
}

// SMS Channel
public class SmsChannel : INotificationChannel
{
    public void Send(NotificationMessage message)
    {
        Console.WriteLine($"Sending SMS to {message.Recipient}: Content: {message.Content.Substring(0, Math.Min(160, message.Content.Length))}");
    }
}

// Push Notification Channel
public class PushChannel : INotificationChannel
{
    public void Send(NotificationMessage message)
    {
        Console.WriteLine($"Sending Push Notification to {message.Recipient}: Content: {message.Content}");
    }
}
```

##### 4. Create the `NotificationService`:
```csharp
public class NotificationService
{
    private readonly IEnumerable<INotificationChannel> _channels;

    public NotificationService(IEnumerable<INotificationChannel> channels)
    {
        _channels = channels;
    }

    public void Notify(NotificationMessage message)
    {
        foreach (var channel in _channels)
        {
            if (channel.GetType().Name.StartsWith(message.ChannelType))
            {
                channel.Send(message);
                break; // Send via the first matching channel
            }
        }
    }
}
```

##### 5. Usage Example:
```csharp
class Program
{
    static void Main(string[] args)
    {
        var channels = new List<INotificationChannel>
        {
            new EmailChannel(),
            new SmsChannel(),
            new PushChannel()
        };

        var notificationService = new NotificationService(channels);

        var emailMessage = new NotificationMessage
        {
            Recipient = "user@example.com",
            Subject = "Appointment Confirmation",
            Content = "<html><body>Your appointment is confirmed.</body></html>",
            ChannelType = "Email"
        };

        var smsMessage = new NotificationMessage
        {
            Recipient = "+1234567890",
            Content = "Your appointment is confirmed.",
            ChannelType = "Sms"
        };

        notificationService.Notify(emailMessage);
        notificationService.Notify(smsMessage);
    }
}
```

---

#### **Output**:
```
Sending Email to user@example.com: Subject: Appointment Confirmation, Content: <html><body>Your appointment is confirmed.</body></html>
Sending SMS to +1234567890: Content: Your appointment is confirmed.
```

---

#### **Future Extensions**:
1. Add a **fallback mechanism** to retry failed notifications.
2. Add support for **WhatsApp**, **Slack**, or other channels.
3. Introduce a **notification preference system** to allow users to choose their preferred channels.

---

This user story and implementation demonstrate how to build a flexible and extensible notification system that adheres to the Dependency Inversion Principle (DIP).