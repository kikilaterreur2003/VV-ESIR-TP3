package fr.istic.vv;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.lang.AssertionError;

/*
test name   
 -methode test- _  r/a rshould reject | a should accept _ Date of test
 */

class DateTest {


   /*
    
            constructor
            
  
    // block 1
    @Test
    void creation_rMonth0() {
    assertThrows(AssertionError.class, () -> {
    Date a = new Date(1,0,1);
    });

    // block 5
    }
    @Test
    void creation_aMonth1() {
    Date a = new Date(1,1,1);
    assert(true);
    }

    // block 2
    @Test
    void creation_rMonth13() {
    assertThrows(AssertionError.class, () -> {
    Date a = new Date(1,13,1);
    });
    }

    // block 3
    @Test
    void creation_rDay0() {
    assertThrows(AssertionError.class, () -> {
    Date a = new Date(0,1,1);
    });
    }

    // block 4
    @Test
    void creation_rDay32() {
    assertThrows(AssertionError.class, () -> {
    Date a = new Date(32,1,1);
    });
    }

    // block 8
    @Test
    void creation_rDay31() {
    assertThrows(AssertionError.class, () -> {
    Date a = new Date(31,4,1);
    });
    }

    @Test
    void creation_aDay31() {
    Date a = new Date(31,1,1);
    assert(true);
    }

    // block 9
    
    @Test
    void creation_aDay30() {
    Date a = new Date(30,4,1);
    assert(true);
    }

    // block 6
    @Test
    void creation_rDay30() {
    assertThrows(AssertionError.class, () -> {
    Date a = new Date(30,2,0);
    });
    }
    @Test
    void creation_aDay29() {
    Date a = new Date(29,2,0);
    assert(true);
    }

    // block 7
    @Test
    void creation_rDay29() {
    assertThrows(AssertionError.class, () -> {
    Date a = new Date(29,2,1);
    });
    }
    @Test
    void creation_aDay28() {
    Date a = new Date(28,2,1);
    assert(true);
    }
    */

    
    /*
    
            isValidDate

     */


    // block 1
    @Test
    void isValidDate_rMonth0() {
    assertTrue(! Date.isValidDate(1,0,1));
    }


    // block 5
    @Test
    void isValidDate_aMonth1() {
    Date a = new Date(1,1,1);
    assertTrue(Date.isValidDate(a.day,a.month,a.year));
    }

    // block 2
    @Test
    void isValidDate_rMonth13() {
    assertTrue(!Date.isValidDate(1,13,1));
    }
    @Test
    void isValidDate_aMonth12() {
    assertTrue(Date.isValidDate(1,12,1));
    }

    // block 3
    @Test
    void isValidDate_rDay0() {
    assertTrue(!Date.isValidDate(0,1,1));
    }

    // block 4
    @Test
    void isValidDate_rDay32() {
    assertTrue(!Date.isValidDate(32,1,1));
    }
    // block 8
    @Test
    void isValidDate_rDay31() {
    assertTrue(! Date.isValidDate(31,4,1));
    }
    @Test
    void isValidDate_aDay31() {
    assertTrue( Date.isValidDate(31,12,1));
    }

    // block 9

    @Test
    void isValidDate_aDay30() {
    Date a = new Date(30,4,1);
    assertTrue(Date.isValidDate(a.day,a.month,a.year));
    }
    // block 6
    @Test
    void isValidDate_rDay30_2() {
    assertTrue(!Date.isValidDate(30,2,4));
    }
    @Test
    void isValidDate_aDay29() {
    Date a = new Date(29,2,4);
    assertTrue(Date.isValidDate(a.day,a.month,a.year));
    }

    // block 7
    @Test
    void isValidDate_rDay29() {
    assertTrue(! Date.isValidDate(29,2,1));
    }

    @Test
    void isValidDate_aDay28() {
    Date a = new Date(28,2,1);
    assertTrue(Date.isValidDate(a.day,a.month,a.year));
    }


   
/*
    
            compareTo

*/
//block 1

@Test
void compareTo_sup_year() {
    Date a = new Date(1,1,1);
    Date b = new Date(1,1,2);
    assertTrue(b.compareTo(a)==1);
    }

//block 2

@Test
void compareTo_inf_year() {
    Date a = new Date(1,1,1);
    Date b = new Date(1,1,2);
    assertTrue(a.compareTo(b)==-1);
    }

//block 3

@Test
void compareTo_sup_month() {
    Date a = new Date(1,1,1);
    Date b = new Date(1,2,1);
    assertTrue(b.compareTo(a)==1);
    }
//block 4
@Test
void compareTo_inf_month() {
    Date a = new Date(1,1,1);
    Date b = new Date(1,2,1);
    assertTrue(a.compareTo(b)==-1);
    }

//block 5

@Test
void compareTo_sup_day() {
    Date a = new Date(1,1,1);
    Date b = new Date(2,1,1);
    assertTrue(b.compareTo(a)==1);
    }

//block 6

@Test
void compareTo_inf_day() {
    Date a = new Date(1,1,1);
    Date b = new Date(2,1,1);
    assertTrue(a.compareTo(b)==-1);
    }
//block 7

@Test
void compareTo_equals() {
    Date a = new Date(1,1,1);
    Date b = new Date(1,1,1);
    assertTrue(a.compareTo(b)==0);
    }
/*
    
            previousDate
*/
// block 1
@Test
void previousDate_day() {
    Date a = new Date(1,1,1);
    Date b = new Date(2,1,1);
    assertTrue(b.previousDate().compareTo(a) == 0);
    }

// block 2

@Test
void previousDate_month31() {
    Date a = new Date(31,10,1);
    Date b = new Date(1,11,1);
    assertTrue(b.previousDate().compareTo(a) == 0);
    }

// block 3
@Test
void previousDate_month30() {
    Date a = new Date(30,11,1);
    Date b = new Date(1,12,1);
    assertTrue(b.previousDate().compareTo(a) == 0);
    }

// block 4
@Test
void previousDate_month29() {
    Date a = new Date(29,2,0);
    Date b = new Date(1,3,0);
    assertTrue(b.previousDate().compareTo(a) == 0);
    }
// block 5
@Test
void previousDate_month28() {
    Date a = new Date(28,2,1);
    Date b = new Date(1,3,1);
    assertTrue(b.previousDate().compareTo(a) == 0);
    }
//block 6
@Test
void previousDate_year() {
    Date a = new Date(31,12,1);
    Date b = new Date(1,1,2);
    assertTrue(b.previousDate().compareTo(a) == 0);
    }

/*
    
            nextDate
*/

//  block 1
@Test
void nextDate_day() {
    Date a = new Date(2,1,1);
    Date b = new Date(1,1,1);
    assertTrue(b.nextDate().compareTo(a) == 0);
    }
//  block 2
@Test
void nextDate_month() {
    Date a = new Date(1,2,1);
    Date b = new Date(31,1,1);
    assertTrue(b.nextDate().compareTo(a) == 0);
    }
//  block 3
@Test
void nextDate_year() {
    Date a = new Date(1,1,2);
    Date b = new Date(31,12,1);
    assertTrue(b.nextDate().compareTo(a) == 0);
    }

/*
    
            isLeapYear
*/
//  block 2
@Test
void isLeapYear_not_leap() {
    assertTrue(Date.isLeapYear(4));
    }
//  block 1
@Test
void isLeapYear__leap() {
    assertTrue(!Date.isLeapYear(1));
    }

}