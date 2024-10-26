import java.util.*;  
class ip_addr_venkatraman {  
    public static int validip(String strtmp){  
             
             
              
            String strarr[] = strtmp.split("\\.");  
            if((strarr.length!=4)||(strtmp.equals(""))||(strtmp.equals("\\s+"))){  
                 
                return 0; 
            }  
            else{  
                for(int i = 0;i<4;i++){  
                    if(!(strarr[i].matches("\\d+"))){  
                        
                        return 0;  
                          
                    }  
                    int tmp = Integer.parseInt(strarr[i]);  
                    if(tmp<0 || tmp>255){  
                        return 0;  
                    }  
                }  
            }  
            return 1;  
          
          
    }  
    public static void main(String[] args) {  
        System.out.println("Try programiz.pro");  
        ArrayList<String> strlst = new ArrayList<String>();  
        System.out.println("enter host name and enter 0 to end");  
        String strtmp="";  
        Scanner sc = new Scanner(System.in);  
        while(!(strtmp.equals("0"))){  
            strtmp = sc.nextLine();  
            if((strtmp.equals("\\s+"))||strtmp.equals("")){  
                 System.out.println("not valid host name");  
            }  
            strlst.add(strtmp.trim());  
        }  
        System.out.println("enter ip address and enter 0 to end");  
        String strip="1";  
        ArrayList<String> strlstip = new ArrayList<String>();  
         while(!(strip.equals("0"))){  
             strip = sc.nextLine();   
             if(strip.equals("0")){  
                 break;  
             }  
             strip = strip.trim();  
            int n = validip(strip);  
            if(n==0){  
                System.out.println("not valid ip");  
            }  
            else{  
                strlstip.add(strip);  
            }  
              
         }  
           
         System.out.println("valid ip's are : ");  
         for(int i = 0;i<strlstip.size();i++){  
             System.out.print(strlstip.get(i) + " ");     
         }  
         
          
    } 
} 



