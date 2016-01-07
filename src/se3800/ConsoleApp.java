package se3800;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * Runs the entire project. Collects information
 * from the console and feeds it to the calculator and history
 * objects. We chose not to use a complicated pattern because
 * modifiability/extensibility is not a concern at all, so its
 * completely legitimate to use a standard design here. We don't plan 
 * to change this after we submit it, so if we can get it to pass
 * the requirements specified and its still fairly clean code
 * there's no point in putting massive amounts of effort into
 * using a Command pattern or maybe a Subscriber model. If we
 * were adding unspecified methods to the calculator later on
 * or something like that, it would make more sense to use a 
 * pattern like this.
 * @author daviesj
 * @author boddyn
 * @version 2016.01.06.1
 */
public class ConsoleApp {
    
    private CalculatorInterface calculator;
    
    private HistoryInterface history;
    
    private boolean exit;
    private static final String command ="Calculator commands are: add, mul, div, sub, and fact.\n"+
                                         "History commands are: clear, and hist.\n"+
                                         "Program commands are: exit.\n";
    public static void main(String [] args){
        ConsoleApp app = new ConsoleApp();
        app.startParsing();
    }
    public ConsoleApp(){
        calculator = new Calculator();
        history = new History(1000);
    }
    /**
     * Creates the scanner and reads from it until
     * the exit command is issued. Note that
     * this will hang.
     * @author daviesj
     */
    public void startParsing(){
        Scanner sc = new Scanner(System.in);
        System.out.println(command);
        while(!exit && sc.hasNextLine()){
            System.out.println(parseLine(sc.nextLine()));
            if(!exit){
                System.out.println(command);
            }
        }
    }
    
    /**
     * Parses a line into the appropriate command, executes the command,
     * and returns the result.
     * @param line A string of input from the user (or wherever).
     * @return The result of the command.
     * @author daviesj
     */
    public String parseLine(String line){
        String [] words = line.trim().split(" ");
        List<Double> dblsList = new ArrayList<Double>();;
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
                            message = ""+calculator.factorial(dblsList.get(0));
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
                //@author boddyn
                case "clear":
                    history.clear();
                    message = "History cleared";
                    break;
                case "hist":
                    message = showHistory(history);
                    break;
                    
                }
            }
            catch(ParamsException pe){
                message = pe.getMessage();
            }
            catch(NegativeException ne){
                message = ne.getMessage();
            }
        }
        if(dblsList == null){
            message = "Incorrect parameters provided";
        }
        return message.replace(".0","")+"\n";
    }
    /**
     * Parses a list of doubles from a string (skips the first one
     * because its a command).
     * @param dblStrings The list of strings to parse into doubles
     * @return The doubles from the parsed strings
     * @author daviesj
     */
    public List<Double> getDoubles(String [] dblStrings){
        List<Double> dbls = new ArrayList<Double>();
        for(int i = 1; i<dblStrings.length; i++){
            try{
                if(dblStrings[i].startsWith("!")){
                    dbls.add(Double.parseDouble(history.getResult(Integer.parseInt(dblStrings[i].replace("!", "")))));
                }
                else{
                    if(dblStrings[i].contains(".")){
                        //Make sure that it doesn't have a decimal place
                        return null;
                    }
                    dbls.add(Double.parseDouble(dblStrings[i]));
                }
            }
            catch(Exception e){
                return null;
            }
        }
        return dbls;
    }
    /**
     * 
     * @param history
     * @return
     * @author boddyn
     */
    private String showHistory(HistoryInterface history) {
        String hist = "";
        int i = 1;
        boolean isMoreHistory = true;
        while (isMoreHistory) {
            try {
                hist = "" + i + ": " + history.getResult(i) + "\n" + hist;
            } catch (IndexOutOfBoundsException ioobe) {
                isMoreHistory = false;
            }
            i++;
        }
        return hist;
    }
    
    /**
     * Signals the program to quit.
     * @author daviesj
     */
    public void exit(){
        exit = true;
    }
}
