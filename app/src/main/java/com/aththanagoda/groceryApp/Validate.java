package com.aththanagoda.groceryApp;

import java.util.regex.Pattern;

public class Validate {

    Pattern phone = Pattern.compile("^(?:0|94|\\+94)?(?:(11|21|23|24|25|26|27|31|32|33|34|35|36|37|38|41|45|47|51|52|54|55|57|63|65|66|67|81|912)(0|2|3|4|5|7|9)|7(0|1|2|5|6|7|8)\\d)\\d{6}$");

    Pattern nic = Pattern.compile("^([0-9]{9}[x|X|v|V]|[0-9]{12}$)");

    public boolean isPhoneNumber(String phone){

        return (this.phone.matcher(phone.subSequence(0,phone.length())).matches());

    }

    public boolean isNIC(String nic){

        return (this.nic.matcher(nic.subSequence(0,nic.length())).matches());

    }
}
