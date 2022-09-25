import java.util.Scanner; 

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String str;
        String[] strArray;
        float sourceNum;
        String sourceMetric;
        String targetMetric;
        float targetNum = 0;
        while( true ){
            System.out.println("Please input your metric to be converted:");
            str = scanner.nextLine();
            if(str.equals("exit")){
                System.out.println("Bye!");
                scanner.close();
                break;
            }
            strArray = str.split(" ");
            if(strArray.length != 4){
                System.out.println("invalid input! Please try again");
                continue;
            }else{
                sourceNum = Float.parseFloat(strArray[0]);
                sourceMetric = strArray[1];
                targetMetric = strArray[3];
                metricConverter(sourceNum, sourceMetric, targetNum, targetMetric);
            }
        }
    }

    public static float metricConverter(float sourceNum, String sourceMetric, float targetNum, String targetMetric){
        switch(sourceMetric){
            case "km":
            switch(targetMetric){
                case "m":
                    targetNum = sourceNum * 1000;
                    break;
                case "mile":
                    targetNum = (float) (sourceNum * 0.62);
                    break;
                default:
                    System.out.println("I don't know that, please give me something else"); 
                    break; 
            }
            break;    
            case "kg":
            switch(targetMetric){
                case "lb":
                    targetNum = (float)(sourceNum * 2.20);
                    break;
                default:
                    System.out.println("I don't know that, please give me something else"); 
                    break; 
            }
            break;
            case "liter":
            switch(targetMetric){
                case "gallon":
                    targetNum = (float)(sourceNum * 0.26);
                    break;
                default:
                    System.out.println("I don't know that, please give me something else"); 
                    break; 
            }
            break;
            case "celsius":
            switch(targetMetric){
                case "fahrenheit":
                    targetNum = (float)(sourceNum * 1.8 + 32);
                    break;
                default:
                    System.out.println("I don't know that, please give me something else"); 
                    break; 
            }
            break;
            default:
                System.out.println("I don't know that, please give me something else"); 
                break; 
        }
        System.out.printf("%.2f %s = %.2f %s%n", sourceNum, sourceMetric, targetNum, targetMetric);
        return targetNum;
    }

}
