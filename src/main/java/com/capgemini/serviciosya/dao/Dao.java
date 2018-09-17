package com.capgemini.serviciosya.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public abstract class Dao<T> {

	private final SessionFactory _sessionFactory;
	private Class<T> _resultClass;

	protected Dao(Class<T> expectedClass){
		_resultClass = expectedClass;
		_sessionFactory = HibernateUtil.getSessionAnnotationFactory();
	}

	protected void create(T target){
		
		checkNullPointer(target, "target", "create");
		
		Session session = null;
        Transaction tx = null;

        try {

            session = _sessionFactory.openSession();
            tx = session.beginTransaction();

            session.save(target);
            tx.commit();

        } catch (Exception e) {

            tx.rollback ();
            throw new DaoException(e.getMessage(), e);

        } finally {

            session.close ();
        }

	}

	protected void update(T target){

		checkNullPointer(target, "target", "update");

		Session session = null;
		Transaction tx = null;

        try {

            session = _sessionFactory.openSession ();
            tx = session.beginTransaction ();

            session.update(target);
            tx.commit ();

        } catch (Exception e) {

            tx.rollback ();
            throw new DaoException (e.getMessage (), e);

        } finally {

            session.close ();
        }
	}

    protected void delete(Integer id){

    	checkNullPointer(id, "id", "delete");

        Session session = null;
        Transaction tx = null;
        T res = null;

        try {

            session = _sessionFactory.openSession ();
            tx = session.beginTransaction ();

            res = _resultClass.cast( session.get(_resultClass, id) );
            if (res != null) {

                session.delete(res);
                tx.commit();
            }

        } catch (Exception e) {

            tx.rollback ();
            throw new DaoException(e.getMessage(), e);

        } finally {

            session.close ();
        }

    }
	
	protected List<T> findAll(){
		
		List<T> list = null;
        Session session = null;

        try {

            session = _sessionFactory.openSession ();
            list = (List<T>) session.createCriteria(_resultClass).list();

        } catch (Exception e) {

            throw new DaoException (e.getMessage (), e);

        } finally {

            session.close ();
        }

        return list;

	}

    protected T findById(Integer id){

    	checkNullPointer(id, "id", "find by id");

    	Session session = null;
    	T ret = null;

        try {

            session = _sessionFactory.openSession();
            ret = _resultClass.cast( session.get(_resultClass, id) );

        } catch (Exception e) {

            throw new DaoException(e.getMessage(), e);

        } finally {

            session.close ();
        }

        return ret;
    }

    protected T findBy(String fieldName, String fieldValue){

        checkNullPointer(fieldName, "fieldName", "find by " + fieldName);
        checkNullPointer(fieldValue, "fieldValue", "find by " + fieldName);
        checkEmptyArgs(fieldName, fieldValue);

        Session session = null;
        T ret = null;

        try {

            session = _sessionFactory.openSession();

            Criteria criteria = session.createCriteria(_resultClass);
            criteria.add(Restrictions.eq(fieldName, fieldValue));

            ret = _resultClass.cast( criteria.uniqueResult() );

        } catch (Exception e) {

            throw new DaoException (e.getMessage(), e);

        } finally {

            session.close ();
        }

        return ret;
    }

    protected List<T> findAllBy(String fieldName, String fieldValue){

		checkNullPointer(fieldName, "fieldName", "find by " + fieldName);
    	checkNullPointer(fieldValue, "fieldValue", "find by " + fieldName);
    	checkEmptyArgs(fieldName, fieldValue);

        Session session = null;
        List<T> list = null;

        try {

            session = _sessionFactory.openSession ();

            Criteria criteria = session.createCriteria(_resultClass);
            criteria.add(Restrictions.eq(fieldName, fieldValue));

            list = (List<T>) criteria.list();

      } catch (Exception e) {

        throw new DaoException (e.getMessage(), e);

      } finally {

        session.close ();
      }

      return list;

    }

    private void checkNullPointer(Object input, String fieldName, String actionName){
    	if( input == null )
    		throw new NullPointerException( String.format("%s can't be null for %s", fieldName, actionName) );
    }

    private void checkEmptyArgs(String... args){
    	for(int i=0; i<args.length; i++)
			if( args[i].isEmpty() )
				throw new IllegalArgumentException( String.format("Argument number %i is null!", i+1) );
    }

}