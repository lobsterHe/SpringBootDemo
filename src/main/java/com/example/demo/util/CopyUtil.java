package com.example.demo.util;

import org.apache.commons.beanutils.PropertyUtils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

/**
 * ========================
 *
 * @author 小龙虾
 * Created with IntelliJ IDEA.
 * Date：2018/5/28
 * Time：16:36
 * Des：
 * ========================
 */
public class CopyUtil {
    public static Object copyProperties(Object dest, Object orig) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        if (dest == null || orig == null) {
            return dest;
        }

        PropertyDescriptor[] destDesc = PropertyUtils.getPropertyDescriptors(dest);
        for (int i = 0; i < destDesc.length; i++) {
            Class destType = destDesc[i].getPropertyType();
            Class origType = PropertyUtils.getPropertyType(orig, destDesc[i].getName());
            if (destType != null && destType.equals(origType) && !destType.equals(Class.class)) {
                if (!Collection.class.isAssignableFrom(origType)) {
                    try {
                        Object value = PropertyUtils.getProperty(orig, destDesc[i].getName());
                        PropertyUtils.setProperty(dest, destDesc[i].getName(), value);
                    } catch (Exception ex) {}
                }
            }
        }

        return dest;
    }

    /**   */
    /**
     * Copy properties of orig to dest Exception the Entity and Collection Type
     *
     * @param dest
     * @param orig
     * @param ignores
     * @return the dest bean
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public static Object copyProperties(Object dest, Object orig, String[] ignores) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        if (dest == null || orig == null) {
            return dest;
        }

        PropertyDescriptor[] destDesc = PropertyUtils.getPropertyDescriptors(dest);
        for (int i = 0; i < destDesc.length; i++) {
            if (contains(ignores, destDesc[i].getName())) {
                continue;
            }

            Class destType = destDesc[i].getPropertyType();
            Class origType = PropertyUtils.getPropertyType(orig, destDesc[i].getName());
            if (destType != null && destType.equals(origType) && !destType.equals(Class.class)) {
                if (!Collection.class.isAssignableFrom(origType)) {
                    Object value = PropertyUtils.getProperty(orig, destDesc[i].getName());
                    PropertyUtils.setProperty(dest, destDesc[i].getName(), value);
                }
            }
        }
        return dest;
    }

    static boolean contains(String[] ignores, String name) {
        boolean ignored = false;
        for (int j = 0; ignores != null && j < ignores.length; j++) {
            if (ignores[j].equals(name)) {
                ignored = true;
                break;
            }
        }

        return ignored;
    }
}
