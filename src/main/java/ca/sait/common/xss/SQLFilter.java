
package ca.sait.common.xss;

import ca.sait.common.exception.RRException;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;

/**
 * This class may be used in some queries in this project.
 */

public class SQLFilter {
    public static String sqlInject(String str){
        if(StringUtils.isBlank(str)){
            return null;
        }


        str = str.toLowerCase();

        String[] keywords = {"master", "truncate", "insert", "select", "delete", "update", "declare", "alter", "drop"};

        for(String keyword : keywords){
            if(str.indexOf(keyword) != -1){
                throw new RRException("Invalid letters");
            }
        }

        return str;
    }
}
