
interface IsendSecureMessage {
    void sendMessage();
    void encriptMessage();
   }
   

  
class SendRSASecureSMS implements IsendSecureMessage {
    
    public void sendMessage() { //send Message }
   
    public void encriptMessage() { // Logic to Encript using RSA}
   }
   
class SendOdinaryEmail implements IsendSecureMessage {
    public void sendMessage() {}
    public void encriptMessage() {
      throw new UnsupportedOperationException();
    }
   }
   

//--------------------------
  
    public SendMessageTest{
   
        public static void main(String[] args) {
          List<IsendSecureMessage> messageList = new ArrayList<IsendSecureMessage>();
          messageList.add(new SendRSASecureSMS());
          messageList.add(new SendOdinaryEmail());
          testEncription(messageList);
        }
        static void testEncription(List<IsendSecureMessage> messageList) {
          for (IsendSecureMessage message : messageList) {
            message.encriptMessage();
          }
        }
       }
   