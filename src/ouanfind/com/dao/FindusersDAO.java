package ouanfind.com.dao;import java.util.Date;import java.util.List;import ouanfind.com.bean.*;public interface FindusersDAO {    public void saveFindusers(Findusers findusers);    public void removeFindusers(Findusers findusers);    public Findusers findFindusersByFindusers_id(Integer findusers_id);    public List<Findusers> findAllFindusers();    public void updateFindusers(Findusers findusers);    public int findFindusersByFindusers_name_count( String findusers_name_c );    public List<Findusers> findFindusersByFindusers_name( String findusers_name_c , int currentPage,int lineSize);    public List<Findusers> findFindusersByFindusers_name_excel( String findusers_name_c );    public List<Findusers_findusers_sex_dict_finddictionary_finddictionary_value>getFindusers_findusers_sex_dict_finddictionary_finddictionary_value();}
