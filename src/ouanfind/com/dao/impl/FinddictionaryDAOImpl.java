package ouanfind.com.dao.impl;import java.util.Date;import java.text.SimpleDateFormat;import java.util.List;import org.hibernate.Hibernate;import org.hibernate.Query;import org.springframework.orm.hibernate3.support.HibernateDaoSupport;import org.hibernate.transform.Transformers;import ouanfind.com.bean.*;import ouanfind.com.dao.FinddictionaryDAO;@SuppressWarnings("unchecked")public class FinddictionaryDAOImpl extends HibernateDaoSupport implements FinddictionaryDAO {    public List<Finddictionary> findAllFinddictionary() {        String hql = "from Finddictionary finddictionary order by finddictionary.fdid ";        return (List<Finddictionary>) this.getHibernateTemplate().find(hql);    }    public Finddictionary findFinddictionaryByFdid(Integer fdid) {        Finddictionary finddictionary = (Finddictionary) this.getHibernateTemplate().get(Finddictionary.class, fdid);        return finddictionary;    }    public void removeFinddictionary(Finddictionary finddictionary) {        this.getHibernateTemplate().delete(finddictionary);    }    public void saveFinddictionary(Finddictionary finddictionary) {        this.getHibernateTemplate().save(finddictionary);    }    public void updateFinddictionary(Finddictionary finddictionary) {        this.getHibernateTemplate().update(finddictionary);    }    public int findFinddictionaryByFdtypeFdnameFdvalueFdremarkFdparentidFddictionarystatusFdoperatorFdoperatedateFdstatus_count( String fdtype_c , String fdname_c , String fdvalue_c , String fdremark_c , Integer fdparentid_c , String fddictionarystatus_c , String fdoperator_c , Date fdoperatedate_c , Integer fdstatus_c ){        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");       String hql_where="";       String hql = " from Finddictionary finddictionary  ";        if (!fdtype_c.equals("")){            if (hql_where.equals(""))            {               hql_where= hql_where + " finddictionary.fdtype='" + fdtype_c + "'" ;             }else             {               hql_where= hql_where + "   AND   finddictionary.fdtype='" + fdtype_c + "'" ;             }         }        if (!fdname_c.equals("")){            if (hql_where.equals(""))            {               hql_where= hql_where + " finddictionary.fdname='" + fdname_c + "'" ;             }else             {               hql_where= hql_where + "   AND   finddictionary.fdname='" + fdname_c + "'" ;             }         }        if (!fdvalue_c.equals("")){            if (hql_where.equals(""))            {               hql_where= hql_where + " finddictionary.fdvalue='" + fdvalue_c + "'" ;             }else             {               hql_where= hql_where + "   AND   finddictionary.fdvalue='" + fdvalue_c + "'" ;             }         }        if (!fdremark_c.equals("")){            if (hql_where.equals(""))            {               hql_where= hql_where + " finddictionary.fdremark='" + fdremark_c + "'" ;             }else             {               hql_where= hql_where + "   AND   finddictionary.fdremark='" + fdremark_c + "'" ;             }         }        if (fdparentid_c!=null){            if (hql_where.equals(""))            {               hql_where= hql_where + " finddictionary.fdparentid='" + fdparentid_c + "'" ;             }else             {               hql_where= hql_where + "   AND   finddictionary.fdparentid='" + fdparentid_c + "'" ;             }         }        if (!fddictionarystatus_c.equals("")){            if (hql_where.equals(""))            {               hql_where= hql_where + " finddictionary.fddictionarystatus='" + fddictionarystatus_c + "'" ;             }else             {               hql_where= hql_where + "   AND   finddictionary.fddictionarystatus='" + fddictionarystatus_c + "'" ;             }         }        if (!fdoperator_c.equals("")){            if (hql_where.equals(""))            {               hql_where= hql_where + " finddictionary.fdoperator='" + fdoperator_c + "'" ;             }else             {               hql_where= hql_where + "   AND   finddictionary.fdoperator='" + fdoperator_c + "'" ;             }         }        if (fdoperatedate_c!=null){            if (hql_where.equals(""))             {               hql_where= hql_where + " finddictionary.fdoperatedate='" + sd.format(fdoperatedate_c) + "'";               }else              {                hql_where= hql_where + "   AND   finddictionary.fdoperatedate='" + sd.format(fdoperatedate_c) + "'" ;              }           }        if (fdstatus_c!=null){            if (hql_where.equals(""))            {               hql_where= hql_where + " finddictionary.fdstatus='" + fdstatus_c + "'" ;             }else             {               hql_where= hql_where + "   AND   finddictionary.fdstatus='" + fdstatus_c + "'" ;             }         }       if (!hql_where.equals(""))         {           hql=hql+" where " + hql_where;          }        return (this.getHibernateTemplate().find(hql)).size();    }    public List<Finddictionary> findFinddictionaryByFdtypeFdnameFdvalueFdremarkFdparentidFddictionarystatusFdoperatorFdoperatedateFdstatus( String fdtype_c , String fdname_c , String fdvalue_c , String fdremark_c , Integer fdparentid_c , String fddictionarystatus_c , String fdoperator_c , Date fdoperatedate_c , Integer fdstatus_c ,int currentPage, int lineSize) {        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");       String hql_where="";          String hql ="select FDID,FDTYPE,FDNAME,FDVALUE,FDREMARK,FDPARENTID,FDDICTIONARYSTATUS,FDOPERATOR,FDOPERATEDATE,FDSTATUS,row_number() over(order by FDID ) as rownum  from finddictionary   ";        if (!fdtype_c.equals("")){            if (hql_where.equals(""))            {               hql_where= hql_where + " finddictionary.fdtype='" + fdtype_c + "'" ;             }else             {               hql_where= hql_where + "   AND   finddictionary.fdtype='" + fdtype_c + "'" ;             }         }        if (!fdname_c.equals("")){            if (hql_where.equals(""))            {               hql_where= hql_where + " finddictionary.fdname='" + fdname_c + "'" ;             }else             {               hql_where= hql_where + "   AND   finddictionary.fdname='" + fdname_c + "'" ;             }         }        if (!fdvalue_c.equals("")){            if (hql_where.equals(""))            {               hql_where= hql_where + " finddictionary.fdvalue='" + fdvalue_c + "'" ;             }else             {               hql_where= hql_where + "   AND   finddictionary.fdvalue='" + fdvalue_c + "'" ;             }         }        if (!fdremark_c.equals("")){            if (hql_where.equals(""))            {               hql_where= hql_where + " finddictionary.fdremark='" + fdremark_c + "'" ;             }else             {               hql_where= hql_where + "   AND   finddictionary.fdremark='" + fdremark_c + "'" ;             }         }        if (fdparentid_c!=null){            if (hql_where.equals(""))            {               hql_where= hql_where + " finddictionary.fdparentid='" + fdparentid_c + "'" ;             }else             {               hql_where= hql_where + "   AND   finddictionary.fdparentid='" + fdparentid_c + "'" ;             }         }        if (!fddictionarystatus_c.equals("")){            if (hql_where.equals(""))            {               hql_where= hql_where + " finddictionary.fddictionarystatus='" + fddictionarystatus_c + "'" ;             }else             {               hql_where= hql_where + "   AND   finddictionary.fddictionarystatus='" + fddictionarystatus_c + "'" ;             }         }        if (!fdoperator_c.equals("")){            if (hql_where.equals(""))            {               hql_where= hql_where + " finddictionary.fdoperator='" + fdoperator_c + "'" ;             }else             {               hql_where= hql_where + "   AND   finddictionary.fdoperator='" + fdoperator_c + "'" ;             }         }        if (fdoperatedate_c!=null){            if (hql_where.equals(""))             {               hql_where= hql_where + " finddictionary.fdoperatedate='" + sd.format(fdoperatedate_c) + "'";               }else              {                hql_where= hql_where + "   AND   finddictionary.fdoperatedate='" + sd.format(fdoperatedate_c) + "'" ;              }           }        if (fdstatus_c!=null){            if (hql_where.equals(""))            {               hql_where= hql_where + " finddictionary.fdstatus='" + fdstatus_c + "'" ;             }else             {               hql_where= hql_where + "   AND   finddictionary.fdstatus='" + fdstatus_c + "'" ;             }         }       if (!hql_where.equals(""))        {              hql=hql+"where " + hql_where;        }          hql="select *  from ("+ hql+ ") row_ where rownum between " + ((currentPage-1)*lineSize+1) + " and " + currentPage*lineSize;           Query queryObject = this.getSession().createSQLQuery(hql)                                      .addScalar("fdid",Hibernate.INTEGER)                                      .addScalar("fdtype",Hibernate.STRING)                                      .addScalar("fdname",Hibernate.STRING)                                      .addScalar("fdvalue",Hibernate.STRING)                                      .addScalar("fdremark",Hibernate.STRING)                                      .addScalar("fdparentid",Hibernate.INTEGER)                                      .addScalar("fddictionarystatus",Hibernate.STRING)                                      .addScalar("fdoperator",Hibernate.STRING)                                      .addScalar("fdoperatedate")                                      .addScalar("fdstatus",Hibernate.INTEGER)                                      .setResultTransformer(Transformers.aliasToBean(Finddictionary.class));              return queryObject.list();    }    public List<Finddictionary> findFinddictionaryByFdtypeFdnameFdvalueFdremarkFdparentidFddictionarystatusFdoperatorFdoperatedateFdstatus_excel( String fdtype_c , String fdname_c , String fdvalue_c , String fdremark_c , Integer fdparentid_c , String fddictionarystatus_c , String fdoperator_c , Date fdoperatedate_c , Integer fdstatus_c ) {        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");        String hql_where="";        String hql = "from Finddictionary finddictionary  ";        if (!fdtype_c.equals("")){            if (hql_where.equals(""))            {               hql_where= hql_where + " finddictionary.fdtype='" + fdtype_c + "'" ;             }else             {               hql_where= hql_where + "   AND   finddictionary.fdtype='" + fdtype_c + "'" ;             }         }        if (!fdname_c.equals("")){            if (hql_where.equals(""))            {               hql_where= hql_where + " finddictionary.fdname='" + fdname_c + "'" ;             }else             {               hql_where= hql_where + "   AND   finddictionary.fdname='" + fdname_c + "'" ;             }         }        if (!fdvalue_c.equals("")){            if (hql_where.equals(""))            {               hql_where= hql_where + " finddictionary.fdvalue='" + fdvalue_c + "'" ;             }else             {               hql_where= hql_where + "   AND   finddictionary.fdvalue='" + fdvalue_c + "'" ;             }         }        if (!fdremark_c.equals("")){            if (hql_where.equals(""))            {               hql_where= hql_where + " finddictionary.fdremark='" + fdremark_c + "'" ;             }else             {               hql_where= hql_where + "   AND   finddictionary.fdremark='" + fdremark_c + "'" ;             }         }        if (fdparentid_c!=null){            if (hql_where.equals(""))            {               hql_where= hql_where + " finddictionary.fdparentid='" + fdparentid_c + "'" ;             }else             {               hql_where= hql_where + "   AND   finddictionary.fdparentid='" + fdparentid_c + "'" ;             }         }        if (!fddictionarystatus_c.equals("")){            if (hql_where.equals(""))            {               hql_where= hql_where + " finddictionary.fddictionarystatus='" + fddictionarystatus_c + "'" ;             }else             {               hql_where= hql_where + "   AND   finddictionary.fddictionarystatus='" + fddictionarystatus_c + "'" ;             }         }        if (!fdoperator_c.equals("")){            if (hql_where.equals(""))            {               hql_where= hql_where + " finddictionary.fdoperator='" + fdoperator_c + "'" ;             }else             {               hql_where= hql_where + "   AND   finddictionary.fdoperator='" + fdoperator_c + "'" ;             }         }        if (fdoperatedate_c!=null){            if (hql_where.equals(""))             {               hql_where= hql_where + " finddictionary.fdoperatedate='" + sd.format(fdoperatedate_c) + "'";               }else              {                hql_where= hql_where + "   AND   finddictionary.fdoperatedate='" + sd.format(fdoperatedate_c) + "'" ;              }           }        if (fdstatus_c!=null){            if (hql_where.equals(""))            {               hql_where= hql_where + " finddictionary.fdstatus='" + fdstatus_c + "'" ;             }else             {               hql_where= hql_where + "   AND   finddictionary.fdstatus='" + fdstatus_c + "'" ;             }         }       if (!hql_where.equals(""))         {           hql=hql+" where " + hql_where;          }        hql = hql+ " order by finddictionary.fdid ";        return (List<Finddictionary>) this.getHibernateTemplate().find(hql);    }}
