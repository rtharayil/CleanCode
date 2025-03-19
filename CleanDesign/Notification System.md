

# User Story: Flexible Notification System

## Title
As a user, I want to receive notifications via multiple channels (e.g., email, SMS, push notifications) so that I can stay informed in a way that is most convenient for me.

---

## User Story
As a **user**,  
I want the system to send me notifications through my preferred channel (e.g., email, SMS, or push notifications),  
so that I can receive important updates in a way that suits my needs.

---

## Acceptance Criteria
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



## Example Workflow
1. A user triggers a notification (e.g., "Your appointment is confirmed").
2. The system determines the user's preferred notification channel(s).
3. The `NotificationService` sends the notification using the appropriate channel(s).
4. The content of the notification is formatted based on the channel:
   - **Email**: HTML content with a subject line.
   - **SMS**: Plain text with a character limit.
   - **Push Notification**: Short text with a call-to-action button.

