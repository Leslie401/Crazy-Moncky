import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class CrazyMoncky {

    /**
    * 计算停车费用 
    * @param parkingDur 停车时间，单位 秒 
    * @return 停车费用， 单位 分
    */
    private static int calParkingFee(long parkingDur) {
        int fee = 0; // free untill open
        return fee; 
    }
    
    public static void main(String[] args) {
        int parkingFee;  
        long parkingDur; 
        LocalDateTime enterTime, leaveTime;

        enterTime = LocalDateTime.parse("2018-05-13 16:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        leaveTime = LocalDateTime.now();

        parkingDur = Duration.between(enterTime, leaveTime).getSeconds();
        parkingFee = calParkingFee(parkingDur);
        
        System.out.printf("total parking time %d, fee %d, please!\n",
                          parkingDur, parkingFee);
    }

}
