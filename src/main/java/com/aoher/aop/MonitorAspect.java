package com.aoher.aop;

import com.aoher.model.Personne;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;

public class MonitorAspect {

    private Logger logger = Logger.getLogger(MonitorAspect.class);

    public void afterReturningSavePersonne(JoinPoint.StaticPart staticPart, Object result) {
        Personne personne = (Personne) result;
        logger.info("Déclenchement de : " + staticPart.getSignature().getName()
                + " Type de Retour : " + result);
    }

    public void beforeSavePersonne(JoinPoint joinPoint) {
        Personne personne = (Personne) joinPoint.getArgs()[0];
        logger.info("parametres d'entrées de la methode : " + personne);
    }

    public void onErrorSavePersonne(JoinPoint joinPoint, Exception e) {
        logger.error("Erreur de type : " + e.getLocalizedMessage()
                + " sur la methode " + joinPoint.getSignature().getName());
    }
}
