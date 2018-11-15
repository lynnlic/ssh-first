var conditions = [
		[ "包含", "等于" ],
		[ "小于", "小于等于", "大于", "大于等于" ]
	];

function getCondition() {
	var type = document.searchForm.type;//得到选择类型框
	var condition = document.searchForm.condition;//得到选择条件框
	var typeCondition = conditions[type.selectedIndex - 1];//得到对应的查询条件数据
	console.log(typeCondition)
	
	for(var i = 0; i < typeCondition.length; i++) {
		condition[i+1] = new Option(typeCondition[i], typeCondition[i])
	}
}

function setFileName(students) {
	var fileName;
	fileName = prompt("请输入下载后文件的名字");
	while(fileName == null || fileName == ""){
		alert("请输入下载后文件的名字！");
		fileName = prompt("请输入下载后文件的名字");		
	} 
	console.log(fileName);
	location.href = '/first/fileDownload.action?fileName='+fileName;
}

function setEditStu(student) {
	session.setAttribute("student", student);
	alert(student);
	console.log("1111");
}
