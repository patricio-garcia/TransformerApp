package cl.desafiolatam.transformerapp;

import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.TimeZone;

@RunWith(MockitoJUnitRunner.class)
public class TransformerPresenterImplTest {

    @Mock
    private TransformerView view;
    private TransformerPresenter presenter;
    private final Calendar calendarDate = Calendar.getInstance(TimeZone.getTimeZone("UTC"));

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        presenter = new TransformerPresenterImpl();
        presenter.setView(view);
    }

    @After
    public void tearDown() {
        presenter.removeView();
    }

    @Test
    public void setDate() {
        //Given -- Dado
        calendarDate.set(2020,1,28);

        //When -- Cuando

        //Then -- Entonces

    }

    @Test
    public void getStringDate() {
    }

    @Test
    public void getDaysOnly() {
    }

    @Test
    public void getWeeksOnly() {
    }

    @Test
    public void getTimeStamp() {
    }

    @Test
    public void getDateFormatOne() {
    }

    @Test
    public void getDateFormatTwo() {
    }

    @Test
    public void getDateFormatThree() {
    }

    @Test
    public void getDateFormatFour() {
    }
}