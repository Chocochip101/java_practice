package next.optional;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;



public class ExpressionTest {
    @Test
    public void of() {
        assertThat(Expression.PLUS == Expression.of("+")).isTrue();
    }
    
    @Test
    public void notValidExpression() {
        Expression.of("&");
        assertThatThrownBy(() -> Expression.of("&")).isInstanceOf(IllegalArgumentException.class);
    }
}
