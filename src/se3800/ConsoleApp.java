package se3800;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleApp {
    private CalculatorInterface calculator;
    private HistoryInterface history;
    private boolean exit;
    
    public static void main(String [] args){
        ConsoleApp app = new ConsoleApp();
    }
    
    public ConsoleApp(){
        Scanner sc = new Scanner(System.in);
        calculator = new Calculator();
        history = new History();
        System.out.println(getMenu());
        while(!exit && sc.hasNextLine()){
            System.out.println(parseLine(sc.nextLine()));
            if(!exit){
                System.out.println(getMenu());
            }
        }
    }
    
    public String getMenu(){
        String command ="Calculator commands are: add,mul,div,sub, and fact.\n";
        command+= "History commands are: clear, and hist.\n";
        command+= "Program commands are: exit.\n";
        return command;
    }
    
    public String parseLine(String line){
        String [] words = line.trim().split(" ");
        List<Double> dblsList = new ArrayList();;
        for(int i = 0; i<words.length;i++){
            words[i].trim();
        }
        String message = "Not enough parameters provided";
        if(words.length>0){
            message = "Command not recognized";
            String cmd = words[0];
            try{
                switch(cmd){
                case "add":
                    dblsList = getDoubles(words);
                    if(dblsList!=null){
                        message = ""+calculator.add(dblsList);
                        history.addResult(message);
                    }
                    break;
                case "sub":
                    dblsList = getDoubles(words);
                    if(dblsList!=null){
                        message = ""+calculator.sub(dblsList);
                        history.addResult(message);
                    }
                    break;
                case "mult":
                    dblsList = getDoubles(words);
                    if(dblsList!=null){
                        message = ""+calculator.mult(dblsList);
                        history.addResult(message);
                    }
                    break;
                case "div":
                    dblsList = getDoubles(words);
                    if(dblsList!=null){
                        message = ""+calculator.div(dblsList);
                        history.addResult(message);
                    }
                    break;
                case "fact":
                    dblsList = getDoubles(words);
                    if(dblsList!=null){
                        if(!dblsList.isEmpty()){
                            message = ""+calculator.factorial(dblsList.get(0).longValue());
                            history.addResult(message);
                        }
                        else{
                            message = "Incorrect parameters provided";
                        }
                    }
                    break;
                case "exit":
                    message = "Exiting...";
                    exit();
                    break;
                case "clear":
                    break;
                case "hist":
                    break;
                    
                }
            }
            catch(ParamsException pe){
                message = "Not enough parameters provided";
            }
        }
        if(dblsList == null){
            message = "Incorrect parameters provided";
        }
        return message+"\n";
    }
    
    public List<Double> getDoubles(String [] dblStrings){
        List<Double> dbls = new ArrayList();
        for(int i = 1; i<dblStrings.length; i++){
            try{
                if(dblStrings[i].startsWith("!")){
                    dbls.add(Double.parseDouble(history.getResult(Integer.parseInt(dblStrings[i].replace("!", "")))));
                }
                else{
                    dbls.add(Double.parseDouble(dblStrings[i]));
                }
            }
            catch(Exception e){
                return null;
            }
        }
        return dbls;
    }
    
    public void exit(){
        exit = true;
    }
}
