package test;

import cn.com.cookie.common.bean.DataRegiste;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Created by Cookie on 2016/4/9.
 */
public class ValidatorTest {

    private static Validator validator;

    @BeforeClass
    public static void setUpValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void notNullTest(){
        DataRegiste data= new DataRegiste();
        data.setId(1L);
        data.setAccount("abc");
        Set<ConstraintViolation<DataRegiste>> constraintViolations =
                validator.validate( data );

        assertEquals( 1, constraintViolations.size() );
        assertEquals( "may not be null", constraintViolations.iterator().next().getMessage() );
    }

}
