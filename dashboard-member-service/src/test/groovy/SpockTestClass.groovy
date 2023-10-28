import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification
import java.math.RoundingMode

class SpockTestClass  extends Specification{

    def "495를 원단위로 반올림하면 500이 된다."() {
        given:
        BigDecimal 금액 = BigDecimal.valueOf(495);

        when:
        BigDecimal 원단위_반올림 = 금액.setScale(-1, RoundingMode.CEILING)

        then:
        원단위_반올림 == 500
    }
}
