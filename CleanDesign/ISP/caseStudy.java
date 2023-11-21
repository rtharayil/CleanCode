interface ISendMessage {
    void send();
   }
   
   
   interface IEncriptMessage {
    void encript();
   }
   
   
   class SendRSASecureSMS implements ISendMessage, IEncriptMessage {
    public void send() {...}
   
    public void encript() {...}
   }
   
   
   class SendOdinaryEmail implements ISendMessage {
    public void send() {...}
   }
   
//--------------------------
  
public SendMessageTest{
   
    public static void main(String[] args) {
      List<IsendSecureMessage> messageList = new ArrayList<IEncriptMessage>();
      messageList.add(new SendRSASecureSMS());
      messageList.add(new SendOdinaryEmail());
      testEncription(messageList);
    }
    static void testEncription(List<IsendSecureMessage> messageList) {
      for (IsendSecureMessage message : messageList) {
        message.encript();
      }
    }
   }

   

   
