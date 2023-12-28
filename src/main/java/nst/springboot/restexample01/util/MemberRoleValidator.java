package nst.springboot.restexample01.util;

import org.springframework.stereotype.Component;

@Component
public class MemberRoleValidator {
    public void validateRole(String memberRole) throws Exception{
        if(memberRole == null || memberRole.isEmpty()){
            throw new Exception("You must input a query type for searching members.");
        }

        if(!memberRole.equalsIgnoreCase("REGULAR")
                && !memberRole.equalsIgnoreCase("DIRECTOR")
                && !memberRole.equalsIgnoreCase("SECRETARY")){
            throw new Exception("Illegal type of member inputted. Valid types are: " +
                    "'REGULAR', 'SECRETARY' and 'DIRECTOR'");
        }
    }
}
