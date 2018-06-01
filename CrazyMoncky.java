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
        int parkingHour ;
        int feePerHour = 200;  // 每小时2元

        if (parkingDur >= 1800) {
            parkingHour = parkingDur / 3600;
            if (parkingDur % 3600 > 0) {
                // 不足一小时按一小时算
                parkingHour += 1;
            }
        } else {
            parkingHour = 0;  // 前半小时免费
        }

        return parkingHour * feePerHour;
	}
		
    /*
    * 车辆进入 
    * @param  licenseID 车牌号
    * @return 是否成功录入
	*/ 
    private static Boolean enter(String licenseID) {
        // 创建一个以licenseid为名称的文件，写入入场的时间戳
        return true;
    } 


    /*
    * 车辆离开
    * @param  licenseID 车牌号
    * @return 停车费用
	*/
    private static int leave(String licenseID) {
        // 读取licenseid为名称的文件，计算停车时间和费用
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
