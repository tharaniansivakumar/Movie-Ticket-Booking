package org.web.service;

import org.hibernate.SessionFactory;
import org.web.modal.util.HBFactory;



	public class FactoryService {
		public static  SessionFactory factory;

		public FactoryService() {
			super();
			factory = HBFactory.get();
		}

		public SessionFactory get() {
			return factory;
		}

	}

