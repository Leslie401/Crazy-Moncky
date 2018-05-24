import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.oracle.tools.packager.RelativeFileSet.Type;

import static java.lang.Math.toIntExact;


public class CrazyMoncky {

    /*
    * 计算停车费用 
    * @param parkingDur 停车时间，单位 秒 
    * @return 停车费用， 单位 分
    * 
    * 计费规则
    * 1: 半小时内免费
    * 2: 每小时两元
    
	*/
    private static int calParkingFee(int parkingDur) {
         // free untill open
		if(parkingDur<=1800)
		{
			return 0; 
		}
		else if(parkingDur>1800 & parkingDur<=3600)
		{
			return 200;
		}
		else if(parkingDur>3600 & parkingDur%3600==0)
		{
			return parkingDur/3600*200;
		}
		else//(parkingDur>3600 & (parkingDur%3600)>0)
		{
			return parkingDur/3600*200+200;
		}
	}
		
    /*
    * 车辆进入 
    * @param  licenseID 车牌号
    * @return 是否成功录入
	*/ 
   private static Boolean enter(String licenseID) {
       return true;
   } 


    /*
    * 车辆离开
    * @param  licenseID 车牌号
    * @return 停车费用
	*/
   private static int leave(String licenseID) {
       return 0;
   }


    /*
     * 输入两个时间，计算停车费用并打印
     * java CrazyMoncky '2018-01-01 00:00:00' '2018-01-01 01:00:00'
     */
    public static void main(String[] args) {
        String action, licenseID;
        Boolean eStat;
        int parkingFee;

        action = args[0];
        licenseID = args[1];

        if (action.equals("e")) {
            eStat = enter(licenseID);
            if (eStat) {
                System.out.printf("Major Lee, entered, have fun\n");
            } else {
                System.out.printf("please go back and try again\n");
            }
        }  else if (action.equals("l")) {
            parkingFee = leave(licenseID);
            System.out.printf("total parking fee %d, please!\n", parkingFee);
        } else {
            System.out.printf(
                "unknown action type %s, only 'e' or 'l' allowed!\n",
                action
            ); 
        }
    }
}
