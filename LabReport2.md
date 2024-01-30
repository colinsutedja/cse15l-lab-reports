```
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
```
<img width="842" alt="Screen Shot 2024-01-30 at 09 52 53" src="https://github.com/colinsutedja/cse15l-lab-reports/assets/156348859/44bfa745-04a2-4ccf-88dd-ab48a33f8e2e"> <br>
- The method that was called was `handleRequest` <br>
- The relevant argument for handleRequest is URI url. The value of the relevant field `show` is `jpolitz: Hello` <br>
- The value of the relevant field `show` changes from an empty String `""` to `jpolitz: Hello` since we used `/add-message` and put the corresponding strings in order into `show` <br>

<img width="932" alt="Screen Shot 2024-01-30 at 09 53 12" src="https://github.com/colinsutedja/cse15l-lab-reports/assets/156348859/d9dbbc7f-ba5b-482a-9ae0-063a4ef872ec"> <br> 

<img width="603" alt="Screen Shot 2024-01-30 at 09 53 25" src="https://github.com/colinsutedja/cse15l-lab-reports/assets/156348859/a90c3df0-a81f-404e-abe4-dad550fc3226"> <br>
