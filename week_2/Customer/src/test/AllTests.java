/**
 * @author Sabina Johnson - skaramuja
 * CIS175 - Fall 2022
 * Aug 30, 2022
 */

package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({ TestCustomer.class, TestTicket.class, TestOrder.class })
public class AllTests {

}
