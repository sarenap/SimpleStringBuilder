
/**
 * class MSB
 * 5 instance vars: start, end, length
 * int1, int0
 */
public class SimpleStringBuilder{
    private CharNode start;
    private CharNode end;
    private int length;
    private static final int ONE =1;
    private static final int ZERO =0;

    /**
     * ctor, create currnode, initialize
     * start end length
     * @param ch
     */
    public SimpleStringBuilder(char ch)
    {
        CharNode currNode = new CharNode(ch);
        start = currNode;
        end = currNode;
        length = ONE;
    }

    /**
     * ctor. initialize length
     * start end. throw nullptrexception.
     * check for empty string
     * @param str
     * @throws Exception
     */
    public SimpleStringBuilder(String str) 
    {
        if(str==null) throw new NullPointerException();
        if(str.length()==ZERO){ //emptystr no nodes
            length = ZERO;
        }
        else{
        length = str.length();
        for(int i=0; i<str.length(); i++){
           append(str.charAt(i));
        }
    }
    }


    /**
     * create msb object by deep copying param msb
     * call previous ctors, deep copy each charnode
     * @param other
     * @throws Exception
     */
    public SimpleStringBuilder(MyStringBuilder other) 
    {
        if(other==null) throw new NullPointerException();

        String otherstr = other.toString(); 
        if( otherstr==null ){
             throw new NullPointerException();}
        if( otherstr.length()==ZERO){
            length = ZERO;
            start = null;
            end = null;
        }
        else{
        length = otherstr.length();
        this.append(otherstr);
    }
    }

    /**
     * returns int length
     * @return length
     */
    public int length(){
        return length;
    }

    /**
     * append char to end of msb object
     * @param ch
     * @return this msb
     */
    public SimpleStringBuilder append(char ch){
        CharNode currNode = new CharNode(ch);
        if( this.start==null){
        start = currNode;
        end = currNode;
        length = ONE; 
        return this;
        } 
        else{
        end.setNext(currNode);
        end = currNode;
        length++;
        return this; 
        }
    }

    /**
     * appends param str to this msb
     * @param str
     * @return this msb
     */
    public SimpleStringBuilder append (String str){
        if(str==null) throw new NullPointerException();
        if(str.length()==ZERO) return this;

            for(int i=0; i<str.length(); i++){
                append(str.charAt(i));
            }
            return this;
    }

    /**
     * to string method of msb
     * using while loop, get data from each charnode
     * and update currnode
     * @return string
     */
    public String toString(){ 
    String str = "";
    CharNode currNode = start;
     while(currNode != null){
        str += currNode.getData();//addchartostring
        currNode = currNode.getNext();
     }
     
    return str;
    }

    /**
     * Returns a substring starting
     *  from startIdx to the end.
     * @param startIdx
     * @return string
     */
    public String subString(int startIdx){
    if(startIdx < ZERO || startIdx >= 
    this.toString().length()){
        throw new IndexOutOfBoundsException();
    } 
        return this.toString().substring(startIdx);
    }

    /**
     * Returns a substring from startIdx 
     * (inclusive) to endIdx (exclusive).
     * @param startIdx
     * @param endIdx
     * @return string
     */
    public String subString(int startIdx, int endIdx){
       if(startIdx == endIdx) return "";
        String str = this.toString();
        if(! (startIdx >=ZERO && startIdx < str.length() &&
        endIdx <= str.length() && endIdx >= startIdx) ){
            throw new IndexOutOfBoundsException();
        }
        return str.substring(startIdx, endIdx);
    }
}