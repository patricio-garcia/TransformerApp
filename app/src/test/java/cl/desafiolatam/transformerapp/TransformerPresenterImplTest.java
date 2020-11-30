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
import java.util.Date;
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
        calendarDate.set(2020,11,28);

        //When -- Cuando
        presenter.setDate(calendarDate.getTimeInMillis());

        //Then -- Entonces
        Mockito.verify(view, Mockito.times(1)).showDateResult();
    }

    @Test
    public void getStringDate() {
        //Given -- Dado
        calendarDate.set(2020,11,28);

        //When -- Cuando
        presenter.setDate(calendarDate.getTimeInMillis());

        //Then
        assertEquals(presenter.getStringDate(), "lunes, diciembre 28, 2020");

    }

    @Test
    public void getDaysOnly() {
        //Given -- Dado
        calendarDate.set(2020,11,28);

        //When -- Cuando
        presenter.setDate(calendarDate.getTimeInMillis());

        //Then
        assertEquals(presenter.getDaysOnly(), "Día del mes: 28");
    }

    @Test
    public void getWeeksOnly() {
        //Given -- Dado
        calendarDate.set(2020,10,28);

        //When -- Cuando
        presenter.setDate(calendarDate.getTimeInMillis());

        //Then
        assertEquals(presenter.getWeeksOnly(), "Semana del año: 48");
    }

    @Test
    public void getTimeStamp() {
        //Given -- Dado
        calendarDate.set(2020,10,28, 00, 00, 00);

        //When -- Cuando
        presenter.setDate(calendarDate.getTimeInMillis());

        //Then
        assertNotNull(presenter.getTimeStamp());
        assertEquals(presenter.getTimeStamp().longValue(), 1606521600000L);
    }

    @Test
    public void getDateFormatOne() {
        //Given -- Dado
        calendarDate.set(2020,10,28);

        //When -- Cuando
        presenter.setDate(calendarDate.getTimeInMillis());

        //Then
        assertEquals(presenter.getDateFormatOne(), "28/11/2020");
    }

    @Test
    public void getDateFormatTwo() {
        //Given -- Dado
        calendarDate.set(2020,10,28);

        //When -- Cuando
        presenter.setDate(calendarDate.getTimeInMillis());

        //Then
        assertEquals(presenter.getDateFormatTwo(), "28 - 11 - 2020");
    }

    @Test
    public void getDateFormatThree() {
        //Given -- Dado
        calendarDate.set(2020,10,28);

        //When -- Cuando
        presenter.setDate(calendarDate.getTimeInMillis());

        //Then
        assertEquals(presenter.getDateFormatThree(), "sáb, nov 28, 2020");
    }

    @Test
    public void getDateFormatFour() {
        //Given -- Dado
        calendarDate.set(2020,10,28);

        //When -- Cuando
        presenter.setDate(calendarDate.getTimeInMillis());

        //Then
        assertEquals(presenter.getDateFormatFour(), "sábado 28");
    }
}