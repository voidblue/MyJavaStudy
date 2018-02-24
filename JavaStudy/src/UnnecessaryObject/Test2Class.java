package UnnecessaryObject;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Test2Class {
    //static으로 객체호출은 한번만 !!
    private final Date birthDate;

    private static Calendar gmtCal;
    private static final Date boomStart;
    private static final Date boomEnd;
    static {
        gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        gmtCal.set(1946, Calendar.JANUARY, 1, 0, 0, 0);
        boomStart = gmtCal.getTime();
        gmtCal.set(1965, Calendar.JANUARY, 1, 0, 0, 0);
        boomEnd = gmtCal.getTime();
    }
    private Test2Class(){
        Calendar gmt = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        gmt.set(1950,1,0,0,0);
        birthDate = gmt.getTime();

    }
    public static Test2Class getInstance(){
        return new Test2Class();
    }
    public boolean isBabyBoomer(){
        //칼렌더가 생성비용이 높아 일단 예제 그대로 사용!

        return birthDate.compareTo(boomStart) >= 0 && birthDate.compareTo(boomEnd) <0;
    }
}
