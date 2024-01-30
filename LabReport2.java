import java.io.IOException;
import java.net.URI;

class Handler implements URLHandler {
    String show = "";
    public String handleRequest(URI url) {
        if (url.getPath().equals("/")) {
            return show;
        } else {
            if (url.getPath().contains("/add-message")) {
                String[] parameters = url.getQuery().split("&");
                String message = "";
                String user = "";
                if (parameters[0].contains("s=")) {
                    String[] stringParameters = parameters[0].split("=");
                    message = stringParameters[1];
                } 
                if (parameters[1].contains("user=")) {
                    String[] userParameters = parameters[1].split("=");
                    user = userParameters[1];
                }
                show += user + ": " + message + "\n";
                return String.format("The message %s has been added!", message);
            }
            return "404 Not Found!";
        }
    }
}

class ChatServer {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new Handler());
    }
}
