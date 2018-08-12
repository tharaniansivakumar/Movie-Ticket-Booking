package org.web.modal.util;


	import org.hibernate.Hibernate;
	import org.hibernate.proxy.HibernateProxy;

	public class HibernateUtilities {

	    public static <T> T unproxy(T proxy) {
	        if (proxy == null) {
	            return null;
	        }

	        if (proxy instanceof HibernateProxy) {
	            Hibernate.initialize(proxy);

	            HibernateProxy hibernateProxy = (HibernateProxy) proxy;
	            @SuppressWarnings("unchecked")
				T unproxiedObject = (T) hibernateProxy.getHibernateLazyInitializer().getImplementation();

	            return unproxiedObject;
	        }

	        return proxy;
	    }
	}
