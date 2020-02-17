package com.argus.cdi.web.cdi.context;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.enterprise.context.NormalScope;
import static java.lang.annotation.ElementType.FIELD;



@Target({TYPE, METHOD, FIELD})
@Retention(RUNTIME)
@Documented
@NormalScope(passivating=true)
@Inherited
public @interface ConversationScoped {}
