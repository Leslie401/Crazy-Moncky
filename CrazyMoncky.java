import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import static java.lang.Math.toIntExact;


public class CrazyMoncky {

    /**
    * 计算停车费用 
    * @param parkingDur 停车时间，单位 秒 
    * @return 停车费用， 单位 分
    * 
    * 计费规则
    * 1: 半小时内免费
    * 2: 每小时两元
    */
    private static int calParkingFee(int parkingDur) {
        int fee = 0; // free untill open
        return fee; 
    }
    

    /**
     * 输入两个时间，计算停车费用并打印
     * java CrazyMoncky '2018-01-01 00:00:00' '2018-01-01 01:00:00'
     */
    public static void main(String[] args) {
        int parkingFee;  
        long parkingDur; 
        String enterTimeStr, leaveTimeStr;
        LocalDateTime enterTime, leaveTime;
        DateTimeFormatter formatter;

        enterTimeStr = args[0];
        leaveTimeStr = args[1];

        formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        enterTime = LocalDateTime.parse(enterTimeStr, formatter);
        leaveTime = LocalDateTime.parse(leaveTimeStr, formatter);

        parkingDur = Duration.between(enterTime, leaveTime).getSeconds();
        parkingFee = calParkingFee(toIntExact(parkingDur));
        
        System.out.printf("total parking time %d, fee %d, please!\n",
                          parkingDur, parkingFee);
    }

}
