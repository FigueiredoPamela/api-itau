package br.com.itau.model;

/**
 *
 * @author PamPam13
 */
public enum CarStatusEnum {
    ACTIVATED,
    DEACTIVATED,
    RESERVED,
    RENTED;
    
    public static boolean isValidCarStatus(String status) {
        for (CarStatusEnum cse : CarStatusEnum.values()) {
            if (cse.name().equals(status)) {
                return true;
            }
        }
        return false;
    }
    
}
