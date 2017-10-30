package com.guilherme.miguel.postgresdemo.config.hibernate.dialect;

import com.guilherme.miguel.postgresdemo.config.hibernate.types.JSONBUserType;
import org.hibernate.dialect.PostgreSQL94Dialect;

import java.sql.Types;

/**
 * @author Miguel Guilherme
 */
public class JSONBPostgreSQLDialect extends PostgreSQL94Dialect {

    public JSONBPostgreSQLDialect() {
        super();
        registerColumnType(Types.JAVA_OBJECT, JSONBUserType.JSONB_TYPE);
    }
}
