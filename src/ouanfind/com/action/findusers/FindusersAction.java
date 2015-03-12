package ouanfind.com.action.findusers;import java.util.ArrayList;import java.util.List;import java.util.Map;import java.util.Date;import java.io.ByteArrayOutputStream;import java.io.InputStream;import java.io.PrintStream;import javax.servlet.http.HttpServletRequest;import org.apache.log4j.Logger;import org.apache.struts2.ServletActionContext;import com.opensymphony.xwork2.ActionContext;import ouanfind.com.service.FindusersService;import ouanfind.com.action.findusers.BaseAction;import ouanfind.com.bean.*;@SuppressWarnings("serial")public class FindusersAction extends BaseAction {    private FindusersService service;    private Findusers findusers;    private String      findusers_name_c;    public  static List <Findusers_findusers_sex_dict_finddictionary_finddictionary_value> Findusers_findusers_sex_dict_finddictionary_finddictionary_valuelist;    //调用分页默认值    int currentPage=1 ; // 定义没页要显示的记录数    int lineSize=10;    // 总记录数 / 每页显示的记录数    int allRecorders;    public FindusersService getService() {        return service;    }    public void setService(FindusersService service) {        this.service = service;    }    public Findusers getfindusers() {        return findusers;    }    public void setFindusers(Findusers findusers) {        this.findusers = findusers;    }    public int getCurrentPage() {        return currentPage;    }    public void setCurrentPage(int currentPage) {        this.currentPage = currentPage;    }    public String  getFindusers_name_c()     {       return  findusers_name_c ;    }    public void  setFindusers_name_c (String findusers_name_c )    {        HttpServletRequest request = ServletActionContext.getRequest();        if (request.getMethod().equals("POST")) {             this.findusers_name_c =findusers_name_c;        } else {            try {                 this.findusers_name_c =findusers_name_c;                 } catch (Exception e) {  }      }    }     public static List<Findusers_findusers_sex_dict_finddictionary_finddictionary_value> getFindusers_findusers_sex_dict_finddictionary_finddictionary_valuelist() {          return Findusers_findusers_sex_dict_finddictionary_finddictionary_valuelist;      }      public static void setFindusers_findusers_sex_dict_finddictionary_finddictionary_valuelist( List<Findusers_findusers_sex_dict_finddictionary_finddictionary_value> findusers_findusers_sex_dict_finddictionary_finddictionary_valuelist) {         Findusers_findusers_sex_dict_finddictionary_finddictionary_valuelist = findusers_findusers_sex_dict_finddictionary_finddictionary_valuelist;      }     @SuppressWarnings("serial")    public String list() throws Exception {        Map request = (Map) ActionContext.getContext().get("request");        request.put("list", service.findAll());        return "listsuccess";    }    @SuppressWarnings("unchecked")    public String saveP() throws Exception {        Findusers_findusers_sex_dict_finddictionary_finddictionary_valuelist = new ArrayList<Findusers_findusers_sex_dict_finddictionary_finddictionary_value>();        Findusers_findusers_sex_dict_finddictionary_finddictionary_valuelist=this.service.getFindusers_findusers_sex_dict_finddictionary_finddictionary_value();        return "saveP";    }    @SuppressWarnings("unchecked")    public String save() throws Exception {        try {            this.service.save(this.findusers);            return "savesuccess";        } catch (Exception e)        {            ByteArrayOutputStream msg = new ByteArrayOutputStream();            e.printStackTrace(new PrintStream(msg));            addActionError("保存出错,堆栈信息如下:</BR>"+msg.toString());             Logger logger = Logger.getLogger(this.getClass());            logger.error("programe error !finduserssaveAction.java "); // 写到日志文件 C:\\log4j_error.log 中            return "saveerror";        }    }    @SuppressWarnings("unchecked")    public String updateP() throws Exception {        Findusers_findusers_sex_dict_finddictionary_finddictionary_valuelist = new ArrayList<Findusers_findusers_sex_dict_finddictionary_finddictionary_value>();        Findusers_findusers_sex_dict_finddictionary_finddictionary_valuelist=this.service.getFindusers_findusers_sex_dict_finddictionary_finddictionary_value();        findusers = this.service.findByFindusers_id(findusers.getFindusers_id());        return "updateP";    }    @SuppressWarnings("unchecked")    public String update() throws Exception {        try {            this.service.update(this.findusers);            return "updatesuccess";        } catch (Exception e)        {            ByteArrayOutputStream msg = new ByteArrayOutputStream();            e.printStackTrace(new PrintStream(msg));            addActionError("保存出错,堆栈信息如下:</BR>"+msg.toString());             Logger logger = Logger.getLogger(this.getClass());            logger.error("programe error !findusersupdateAction.java "); // 写到日志文件 C:\\log4j_error.log 中            return "updateerror";        }    }    @SuppressWarnings("unchecked")    public String remove() throws Exception {        this.service.delete(findusers);        return "removesuccess";    }    @SuppressWarnings("unchecked")    public String listByFindusers_name() throws Exception {        Map request = (Map) ActionContext.getContext().get("request");        if ( this.getFindusers_name_c()==null )         {            this.setFindusers_name_c("");          }         allRecorders = service.findFindusersByFindusers_name_count( this.getFindusers_name_c() ) ;        request.put("currentPage",new Integer(currentPage)) ; //当前页        request.put("allRecorders",new Integer(allRecorders)) ;//总记录总数        request.put("list", service.findFindusersByFindusers_name( this.getFindusers_name_c() ,this.getCurrentPage(),lineSize));        return "listByFindusers_name";    }    @SuppressWarnings("unchecked")    public InputStream getDownloadFile() {        return this.service.getInputStream( this.getFindusers_name_c() );    }    @SuppressWarnings("unchecked")    public String generateExcel() throws Exception {          return "generateExcel";    }}
