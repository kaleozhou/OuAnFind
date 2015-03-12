<%@ page contentType="text/html; charset=utf-8"%><%@ page language="java" import="java.util.*" pageEncoding="GBK"%><%@ taglib prefix="s" uri="/struts-tags"%><!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><html>    <head>            <title>Findusers 操作主界面</title><style>.tdLabel {    text-align: right;}</style>        <meta http-equiv="pragma" content="no-cache">        <meta http-equiv="cache-control" content="no-cache">        <meta http-equiv="expires" content="0">        <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">        <meta http-equiv="description" content="This is my page">    <SCRIPT LANGUAGE="JavaScript">            imgsrc=new Array();            imgsrc[1]="c_c1.gif";            imgsrc[2]="c_c2.gif";            img =new Array();            for (i=0; i< imgsrc.length; i++) {              img[i]=new Image();              img[i].src="image\\"+imgsrc[i];            }            function change(number, picture) {              {                document[picture].src=img[number].src;              }            }            function del()            {                if(confirm("你真的想删除该记录么？"))                {                    return true;                }                return false;            }           function openPage(curpage)           {                document.all("currentPage").value = curpage ;                document.forms[0].submit();           }            function sort(tableId, sortColumn,nodeType) {             var table = document.getElementById("findusers");             var tableBody = table.tBodies[0];             var tableRows = tableBody.rows;             var rowArray = new Array();             for (var i = 0; i < tableRows.length; i++) {                 rowArray[i] = tableRows[i];             }             if (table.sortColumn == sortColumn) {                 rowArray.reverse();             } else {                 rowArray.sort(generateCompareTR(sortColumn, nodeType));             }             var tbodyFragment = document.createDocumentFragment();             for (var i = 0; i < rowArray.length; i++) {                 tbodyFragment.appendChild(rowArray[i]);             }             tableBody.appendChild(tbodyFragment);             table.sortColumn = sortColumn;            }            function generateCompareTR(sortColumn, nodeType) {             return function compareTR(trLeft, trRight) {              try{                   var leftValue = convert(trLeft.cells[sortColumn].firstChild.nodeValue, nodeType);                   var rightValue = convert(trRight.cells[sortColumn].firstChild.nodeValue, nodeType);                   if (leftValue < rightValue) {                       return -1;                   } else {                       if (leftValue > rightValue) {                           return 1;                       } else {                           return 0;                       }                   }                 }catch (e)                 {                    return 0;                  }             };            }            function convert(value, dataType) {             switch (dataType) {               case "Integer":                 return parseInt(value);                case "Float":                  return parseFloat(value);                default:                  return value.toString();              }             }     </script>    <link rel="stylesheet" href="css/table_design.css" type="text/css"></link></head>    <body style="font-size:15px">    <%      //和ListFindusersByFindusers_nameAction.java文件里定义的默认值保持一致即可      // 定义如下分页变量      int currentPage =1;    // 1、定义当前是第几页，默认是第1页      int lineSize= 10 ;     // 2、定义每页要显示的记录数，默认是每页10条      int allRecorders = 0 ; // 3、计算出实际记录数，默认      int pageSize= 0 ;      // 4、计算出实际页数，默认    %>    <%      if(request.getAttribute("currentPage")!=null)       currentPage=((Integer) request.getAttribute("currentPage") ).intValue();      if(request.getAttribute("allRecorders")!=null)       allRecorders=((Integer) request.getAttribute("allRecorders") ).intValue();      if(request.getAttribute("currentPage")!=null&&request.getAttribute("allRecorders")!=null)       pageSize = (allRecorders+lineSize-1)/lineSize ;     %>        <br>        <s:form name="form1" action="finduserslistByFindusers_name.action" method="post" >            <table border="1" style="BORDER-COLLAPSE: collapse" width="35%"                align="center" bgcolor="#FFFFCC" >                <tr align=center  bgcolor="#CCFF66">                    <td colspan="2">                        Findusers 自定义查询条件                    </td>                     <s:textfield id="findusers_name_c" name="findusers_name_c" label="findusers_name"></s:textfield>                    <s:hidden  name="currentPage" value="1"></s:hidden>                    <td colspan="2" align="center" >                    <IMG NAME="m1" SRC="image\c_c2.gif" BORDER="0" vspace="0" hspace="0" ONMOUSEOVER="change('1','m1')" ONMOUSEOUT= "change('2','m1')" onClick="form1.submit()" title="温馨提示:查询全部记录，不用输入任何条件!">                    </td>                    <!-- 也可以用下面的提交方式                    <s:submit name="s1" value="查 询" align="center"></s:submit>                     -->                </tr>            </table>        </s:form>        <br>        <table width="80%" align="center">         <s:url id="url_savefindusers" action="finduserssaveP">             <s:param name="findusers_name_c"><s:property value="#request.findusers_name_c" /></s:param>         </s:url>         <s:a href="%{url_savefindusers}">添加新记录</s:a>        </table>        <hr color="#CCCCFF">        <table id="findusers" border="1" width="80%" align="center" bgcolor="#FFFFCC"            style="BORDER-COLLAPSE: collapse" >        <thead>            <tr align="center" bgcolor="#CCFF66"  title="单击栏头,可以降序或升序排列">                 <td onClick="sort(findusers,0,'Integer')">                    findusers_id                </td>                 <td onClick="sort(findusers,1,'String')">                    findusers_name                </td>                 <td onClick="sort(findusers,2,'String')">                    findusers_realname                </td>                 <td onClick="sort(findusers,3,'String')">                    findusers_nickname                </td>                 <td onClick="sort(findusers,4,'String')">                    findusers_sex                </td>                 <td onClick="sort(findusers,5,'String')">                    findusers_password                </td>                 <td onClick="sort(findusers,6,'Integer')">                    findusers_age                </td>                 <td onClick="sort(findusers,7,'String')">                    findusers_address                </td>                 <td onClick="sort(findusers,8,'String')">                    findusers_provience                </td>                 <td onClick="sort(findusers,9,'String')">                    findusers_city                </td>                 <td onClick="sort(findusers,10,'String')">                    findusers_county                </td>                 <td onClick="sort(findusers,11,'String')">                    findusers_email                </td>                 <td onClick="sort(findusers,12,'String')">                    findusers_teleph                </td>                 <td onClick="sort(findusers,13,'String')">                    findusers_nationality                </td>                 <td onClick="sort(findusers,14,'String')">                    findusers_nation                </td>                 <td onClick="sort(findusers,15,'String')">                    findusers_constellation                </td>                 <td onClick="sort(findusers,16,'String')">                    findusers_bloodtype                </td>                 <td onClick="sort(findusers,17,'Integer')">                    findusers_stature                </td>                 <td onClick="sort(findusers,18,'Integer')">                    findusers_weight                </td>                 <td onClick="sort(findusers,19,'String')">                    findusers_homepace                </td>                 <td onClick="sort(findusers,20,'Date')">                    findusers_datebirth                </td>                 <td onClick="sort(findusers,21,'String')">                    findusers_vocation                </td>                 <td onClick="sort(findusers,22,'Integer')">                    findusers_qq                </td>                 <td onClick="sort(findusers,23,'String')">                    findusers_graduateschool                </td>                 <td onClick="sort(findusers,24,'String')">                    findusers_currentcompany                </td>                 <td onClick="sort(findusers,25,'String')">                    findusers_specialskill                </td>                 <td onClick="sort(findusers,26,'String')">                    findusers_accomplish                </td>                 <td onClick="sort(findusers,27,'Integer')">                    findusers_empiricvalue                </td>                 <td onClick="sort(findusers,28,'Integer')">                    findusers_viplevel                </td>                 <td onClick="sort(findusers,29,'String')">                    findusers_headsculpture1                </td>                 <td onClick="sort(findusers,30,'String')">                    findusers_headsculpture2                </td>                 <td onClick="sort(findusers,31,'Date')">                    findusers_registerdate                </td>                 <td onClick="sort(findusers,32,'String')">                    findusers_operater                </td>                 <td onClick="sort(findusers,33,'Date')">                    findusers_operatedate                </td>                 <td onClick="sort(findusers,34,'Integer')">                    findusers_status                </td>                <td colspan="2">                    function                </td>            </tr>          </thead>            <s:iterator value="#request.list" id="findusers" >                <tr align="center" onmousemove="return this.bgColor='#FDF525';"  onmouseout="return this.bgColor='';">                 <td >                        <s:property value="#findusers.findusers_id" />                </td>                 <td >                        <s:property value="#findusers.findusers_name" />                </td>                 <td >                        <s:property value="#findusers.findusers_realname" />                </td>                 <td >                        <s:property value="#findusers.findusers_nickname" />                </td>                 <td >                        <s:property value="#findusers.findusers_sex" />                </td>                 <td >                        <s:property value="#findusers.findusers_password" />                </td>                 <td >                        <s:property value="#findusers.findusers_age" />                </td>                 <td >                        <s:property value="#findusers.findusers_address" />                </td>                 <td >                        <s:property value="#findusers.findusers_provience" />                </td>                 <td >                        <s:property value="#findusers.findusers_city" />                </td>                 <td >                        <s:property value="#findusers.findusers_county" />                </td>                 <td >                        <s:property value="#findusers.findusers_email" />                </td>                 <td >                        <s:property value="#findusers.findusers_teleph" />                </td>                 <td >                        <s:property value="#findusers.findusers_nationality" />                </td>                 <td >                        <s:property value="#findusers.findusers_nation" />                </td>                 <td >                        <s:property value="#findusers.findusers_constellation" />                </td>                 <td >                        <s:property value="#findusers.findusers_bloodtype" />                </td>                 <td >                        <s:property value="#findusers.findusers_stature" />                </td>                 <td >                        <s:property value="#findusers.findusers_weight" />                </td>                 <td >                        <s:property value="#findusers.findusers_homepace" />                </td>                 <td >                        <s:date name="#findusers.findusers_datebirth" format="yyyy-MM-dd HH:mm:ss"/>                </td>                 <td >                        <s:property value="#findusers.findusers_vocation" />                </td>                 <td >                        <s:property value="#findusers.findusers_qq" />                </td>                 <td >                        <s:property value="#findusers.findusers_graduateschool" />                </td>                 <td >                        <s:property value="#findusers.findusers_currentcompany" />                </td>                 <td >                        <s:property value="#findusers.findusers_specialskill" />                </td>                 <td >                        <s:property value="#findusers.findusers_accomplish" />                </td>                 <td >                        <s:property value="#findusers.findusers_empiricvalue" />                </td>                 <td >                        <s:property value="#findusers.findusers_viplevel" />                </td>                 <td >                        <s:property value="#findusers.findusers_headsculpture1" />                </td>                 <td >                        <s:property value="#findusers.findusers_headsculpture2" />                </td>                 <td >                        <s:date name="#findusers.findusers_registerdate" format="yyyy-MM-dd HH:mm:ss"/>                </td>                 <td >                        <s:property value="#findusers.findusers_operater" />                </td>                 <td >                        <s:date name="#findusers.findusers_operatedate" format="yyyy-MM-dd HH:mm:ss"/>                </td>                 <td >                        <s:property value="#findusers.findusers_status" />                </td>                    <td>                             <s:url id="url_deletefindusers" action="findusersremove">                             <s:param name="findusers.findusers_id"><s:property value="#findusers.findusers_id" /></s:param>                             <s:param name="findusers_name_c"><s:property value="#request.findusers_name_c" /></s:param>                               </s:url>                               <s:a href="%{url_deletefindusers}" onclick="return del();">删除</s:a>                        <font color="#808080" size="3">|</font>                             <s:url id="url_updatefindusers" action="findusersupdateP">                             <s:param name="findusers.findusers_id"><s:property value="#findusers.findusers_id" /></s:param>                             <s:param name="findusers_name_c"><s:property value="#request.findusers_name_c" /></s:param>                               </s:url>                               <s:a href="%{url_updatefindusers}">修改</s:a>                        <font color="#808080" size="3">|</font>                        <s:a href="#">其他功能</s:a>                    </td>                </tr>            </s:iterator>        </table>       <s:if test="#findusers">          <% if (pageSize!=0) {%>          <table border="1" width="80%" align="center" bgcolor="#FFFFCC"             style="BORDER-COLLAPSE: collapse" >          <tr align="right"  bgcolor="#FFFFFF">              <td colspan=36>              <input style="background-color:Transparent;border-left:none; border-top:none;border-right:none;border-bottom:none;cursor:hand;" type="button" value="首页" onClick="openPage(1)" <%=currentPage==1?"disabled":""%>>              <input style="background-color:Transparent;border-left:none; border-top:none;border-right:none;border-bottom:none;cursor:hand;" type="button" value="上一页" onClick="openPage(<%=currentPage-1%>)" <%=currentPage==1?"disabled":""%>>              <input style="background-color:Transparent;border-left:none; border-top:none;border-right:none;border-bottom:none;cursor:hand;" type="button" value="下一页" onClick="openPage(<%=currentPage+1%>)" <%=currentPage==pageSize?"disabled":""%>>              <input style="background-color:Transparent;border-left:none; border-top:none;border-right:none;border-bottom:none;cursor:hand;" type="button" value="尾页" onClick="openPage(<%=pageSize%>)" <%=currentPage==pageSize?"disabled":""%>>              <input style="background-color:Transparent;border-left:none; border-top:none;border-right:none;border-bottom:none;cursor:hand;" type="button" value=[<%=currentPage%>/<%=pageSize%>页]>              </td>           </tr>           </table>           <% }%>       </s:if>        <br>         <center>              <!-- 判断 findusers对象是否为空的方法如下：-->              <s:if test="!#findusers">                    没有查询到任何记录!              </s:if>        </center><br>        <center>                              <s:url id="url_excelfindusers" action="findusersgenerateExcel">                              <s:param name="findusers_name_c"><s:property value="#request.findusers_name_c" /></s:param>                              </s:url>                              <s:a href="%{url_excelfindusers}"><font color="#008000" size="3">生成 Excel 文件</font></s:a>            <a href="index.jsp"><font color="#808080" size="3">返回首页</font>            </a>        </center>    </body></html>
