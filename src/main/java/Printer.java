public class Printer {

    private StringBuilder str;

    Printer (){
        str = new StringBuilder("");
    }

    public String getStr(){
        return str.toString();
    }

    public void print(){
        System.out.println(str);
    }

    public void clear(){
        str.setLength(0);
    }

    public void addtoStrLn(String inputStr){
        str.append(inputStr+"\n");
    }

    public void addtoStr(String inputStr){
        str.append(inputStr+"   ");
    }

}
