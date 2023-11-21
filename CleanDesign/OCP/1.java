public class Parser {


}

abstract class CommandHandler {

    CommandHandler next;

    void setNext(CommandHandler){
        next =CommandHandler;
    }

    void handleRequest(){
        next.handleRequest(String)
    }
}

public class DollarCommand implements CommandHandler{
    

    void handleRequest(String){
        
    }
}

   