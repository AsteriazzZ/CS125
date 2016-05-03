public class Class {
	
	private String dep;
    private int num;
    private String des;
    private int time;
    private char[] days;
    private int credit;
    private boolean required;
    private Class next;
    
    public Class(String dep, int num, String des, int time, char[] days, int credit,boolean required, Class next){
        this.dep = dep;
        this.num = num;
        this.des = des; 
        this.time = time;
        this.required = required;
        this.days = days;
        this.credit = credit;
        this.next = next;
    }
    
    public Class(String dep, int num){
        this.dep = dep;
        this.num = num;
        this.next = null;
    }
    
    public void copy(Class oldclass){
        this.dep = oldclass.dep;
        this.num = oldclass.num;
        this.des = oldclass.des;
        this.time = oldclass.time;
        this.required = oldclass.required;
        this.days = oldclass.days;
        this.credit = oldclass.credit;
        this.next = oldclass.next;
    }
    
    public boolean conflict(Class newclass){
        if(this.time == newclass.time){
            for(int i=0; i<this.days.length; i++)
                for(int j=0; j<newclass.days.length; j++){
                if(this.days[i] == newclass.days[j])
                    return true;
            }
        }
        if(this.next == null)
            return false;
        return next.conflict(newclass);
    }
    
    public Class Add(Class newclass){
        if(newclass.dep.compareTo(this.dep)==0){
            if(this.next==null){
                if(this.num>newclass.num){
                    newclass.next=this;
                    return newclass;
                }
                this.next=newclass;
                return this;
            }
            
            if(this.dep.equals(newclass.dep)){
                if(newclass.num>this.num){
                    this.next=next.Add(newclass);
                    return this;
                }
                newclass.next=this;
                return newclass;
            }
            this.next=next.Add(newclass);
            return this;
        }
        if(next==null){
            if(newclass.dep.compareTo(this.dep)<0){
                newclass.next=this;
                return newclass;
            }
            this.next=newclass;
            return this;
        }
        if(newclass.dep.compareTo(this.dep)>0){
            this.next=this.next.Add(newclass);
            return this;
        }
        newclass.next=this;
        return newclass;
    }

    public boolean findSameDep(Class newclass){
        if(this.dep==newclass.dep)
            return true;
        if(this.next==null)
            return false;
        return next.findSameDep(newclass);
    }
    
    public Class remove(int a){
        if(this.next==null)
            return null;
        if(a==1){
            return this.next;
        }
        this.next=next.remove(a-1);
        return this;    
    }
    
    public void print(){
        this.print(1);
    }
    
    public static String toString(char[] array){
        String temp="";
        for(int i =0; i<array.length;i++){
            temp= temp+array[i];
        }
        return temp;
    }
    
    public void print(int count){
        if(next==null){
            if(required){
                System.out.println(count+") "+dep+" "+num+" "+des+" "+time+" "+toString(days)+" "+credit+" "+"*");
                return;
            }
            System.out.println(count+") "+dep+" "+num+" "+des+" "+time+" "+toString(days)+" "+credit);
            return;
        }
        if(required){
            System.out.println(count+") "+dep+" "+num+" "+des+" "+time+" "+toString(days)+" "+credit+" "+"*");
        }else{
            System.out.println(count+") "+dep+" "+num+" "+des+" "+time+" "+toString(days)+" "+credit);
            }
        next.print(count+1);
    }
    
    public void newprint(){
        if(next==null){
            System.out.println(dep+num);
            return;
        }
        System.out.println(dep+num);
        next.newprint();
    }

    //#4
    public String course_major(int count,String result){
        if(this.required) result +=count +")"+ dep+" "+num+" "+des+" "+time+" "+toString(days)+" "+credit+"\n";
        if(next == null) return result;
        return next.course_major(count+1,result);           
    }
    
    //#5
    public int courses_number(char a, int count){       
        for(int i = 0; i<days.length;i++){
            if((int)days[i]==(int)a || (int)days[i] == (int)(a-32)) {
                count++;
                //System.out.println(this.num);
                break;
            }
        }
        if(next == null) return count;
        return next.courses_number(a, count);   
    }
    public Class[] toArray(char a, int count,Class [] courseslist){
        for(int i = 0; i<days.length;i++){
            if((int)days[i]==(int)a || (int)days[i] == (int)(a-32)) {
                courseslist[count] = this;
                //  System.out.println(count + ") " +courseslist[count].num);
                count++;
                break;
            }
        }
        if(next == null) return courseslist;
        return next.toArray(a,count, courseslist);
    }
    public static int findMin(Class[] data, int lo, int hi) {
        if(lo == hi) return lo;
        if(data[lo].time < data[findMin(data, lo+1, hi)].time) return lo;
        return findMin(data,lo+1, hi);
    }
    public static void sort(Class[] data) {
        sort(data,0,data.length-1);
    }
    public static void sort(Class[] data, int lo, int hi) {
        if(lo == hi) return;
        swap(data, lo , findMin(data,lo,hi) );
        sort(data, lo+1, hi);
    }
    public static void swap(Class [] courseslist,int i,int j){
        Class temp = courseslist[i];
        courseslist[i] = courseslist[j];
        courseslist[j] = temp;
    }   
    public static void print(Class [] courseslist){
        for(int i = 0; i<courseslist.length; i++){
            System.out.println((i+1)+")"+courseslist[i].dep + " "+courseslist[i].num+" " +courseslist[i].des+" course_time:"+
                    courseslist[i].time+" "+courseslist[i].credit);
        }
    }

    //#6
    public int totalCredits(){
        if(next == null) return this.credit;
        int total = this.credit + next.totalCredits();
        return total;
    }
    public static void main(String[] args){
        //char[] array= new char[]{'m','w','f'};
        Class classlist=null;
        //classlist= new Class("ABE",226,"1",7,array,3,true,null);
        //classlist= classlist.Add(new Class("ABE",225,"1",8,array,3,true,null));
        //classlist= classlist.Add(new Class("ABE",227,"1",8,array,3,true,null));
        //classlist= classlist.Add(new Class("ABE",220,"1",8,array,3,true,null));
        //classlist= classlist.Add(new Class("MATH",241,"1",8,array,3,true,null));
        //classlist= classlist.Add(new Class("MATH",231,"1",8,array,3,true,null));
        
        System.out.println("Welcome to the Course Scheduler!  Select an option below:");
        System.out.println("");
        System.out.println("1) add an course");
        System.out.println("2) remove a course");
        System.out.println("3) display courses alphabetically");
        System.out.println("4) display courses in major");
        System.out.println("5) display schedule for day");
        System.out.println("6) display total number of credit hours");
        System.out.println("7) quit");
        System.out.println("");
        int num=0;
        
        while(true){
            System.out.print("Select an option above:");
            int selection= TextIO.getlnInt();
            if(selection==1){
                System.out.print("Department:");
                String dep=TextIO.getlnString().toUpperCase();
                System.out.print("Course Number:");
                num=TextIO.getlnInt();
                System.out.print("Course Description:");
                String des=TextIO.getlnString();
                System.out.print("Starting Hour:");
                int time=TextIO.getlnInt();
                System.out.print("Days:");
                char[] days=TextIO.getlnString().toUpperCase().toCharArray();
                System.out.print("Credit Hours:");
                int credit=TextIO.getlnInt();
                System.out.print("Required for Major?");
                boolean required=TextIO.getlnBoolean();
                Class temp = new Class(dep,num,des,time,days,credit,required,null);
                if(classlist==null){
                    classlist=temp; 
                    System.out.println("Course Added!");
                    System.out.println(""); 
                }else{
                    if(classlist.conflict(temp)){
                        System.out.println("There is a time conflict with another course!");
                        System.out.println(""); 
                    }else{
                        classlist=classlist.Add(temp);
                        System.out.println("Course Added!");
                        System.out.println(""); 
                        
                    }
                }
            }
            
            if(selection==2){
                if(classlist==null){
                    System.out.println("There is no course added!");
                    System.out.println(""); 
                }
                else{
                    classlist.print();
                    System.out.println(""); 
                System.out.print("Which course you want to remove:");
                int a= TextIO.getlnInt();
                classlist=classlist.remove(a);
                System.out.println("Course Removed!");
                System.out.println("");
                }
            }
            
            if(selection==3){
                if(classlist==null){    
                    System.out.println("There is no course added!");
                    System.out.println(""); 
                }
                else{
                    classlist.print();
                    System.out.println(""); 
                }
                   
            }
            
            if(selection==4){
                if(classlist==null){
                    System.out.println("There is no course added!");    
                    System.out.println(""); 
                }                                               
                else{
                System.out.print(classlist.course_major(1,""));
                System.out.println("");
                }
            }
            
            if(selection==5){
                if(classlist==null){
                    System.out.println("There is no course added!");    
                    System.out.println(""); 
                    
                }       
                else{
                System.out.print("Please type the day (MTWRF) to check daily schedule:" );
                char input = TextIO.getlnChar();
                int length = classlist.courses_number(input, 0);
                //System.out.println(length);
                Class [] courseslist = new Class [length];
                classlist.toArray(input, 0, courseslist);
                Class.sort(courseslist);   
                Class.print(courseslist);
                System.out.println("");
                }
            }
            if(selection==6){
                if(classlist==null){
                    System.out.println("There is no course added!");    
                    System.out.println(""); 
                }                                                       
                else{
                System.out.println("Total Credits:" +classlist.totalCredits()); 
                System.out.println("");
                }      
            }
            
            if(selection==7){
                System.out.println("Are you sure you want to quit? - all your data will be lost.");
                Boolean temp=TextIO.getlnBoolean();
                if(temp)
                    break;
                System.out.println("");
            }
            
            if(selection>=8||selection<=0){
                System.out.println("Please enter a integer between 1 and 7.");
                System.out.println("");
            }
        }
    }

}
