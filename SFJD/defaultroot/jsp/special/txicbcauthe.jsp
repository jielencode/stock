<%--
	ͩ����Ŀ������������ȡUK���û���֤��Ϣ��js����
--%>
<script type="text/javascript">
	//����Ƿ�忨
	function checkCard() {
		var flag = CtrlSPK.CheckCard();
		return flag;
	}
	
	//��ȡ�û���Ϣ:11λ�ͻ���+3λ�����
	function readUserInfo(pin) {
		var userInfo = "";
		var userNo = "";
		var delegateNo = "";
		
		var flag = CtrlSPK.ReadData(1, pin, 124, 20);
		if (flag == "0") {
			userNo = CtrlSPK.GetResult();
		} else {
			userNo = "error";
		}
		flag = CtrlSPK.ReadData(1, pin, 144, 5);
		if (flag == "0") {
			delegateNo = CtrlSPK.GetResult();
		} else {
			delegateNo = "error";
		}
		return userNo + delegateNo;
	}
	
	//��ȡǩ����Ϣ
	function signData(pin, data) {
		var flag = CtrlSPK.SignData(1, pin, data, data.length);
		if (flag == "0") {
			return CtrlSPK.GetResult();
		} else {
			return "error";
		}
	}
	
	//��ȡ֤����Ϣ
	function readCerInfo(pin) {
		var flag = CtrlSPK.ReadData(1, pin, 0, 159);
		if (flag == "0") {
			return CtrlSPK.GetResult();
		} else {
			return "error";
		}
	}
	
	//��ȡ��Կ��Ϣ
	function readPublicKey() {
		var flag = CtrlSPK.ReadPulicKey(1);
		if (flag == "0") {
			return CtrlSPK.GetResult();
		} else {
			return "error";
		}
	}
	
	//��ȡ��֤����ǩ����Ϣ
	function readKeyInfo(pin) {
		var flag = CtrlSPK.ReadData(1, pin, 287, 128);
		if (flag == "0") {
			return CtrlSPK.GetResult();
		} else {
			return "error";
		}
	}
	
	//�޸�pin��
	function changePin(oldPin, newPin) {
		var flag = CtrlSPK.ChangePIN(oldPin, newPin);
		if (flag == "0") {
			return "0";
		} else {
			return "error";
		}
	}
</script>
<OBJECT ID="CtrlSPK" CLASSID="CLSID:1FAC4FD1-9B6B-47E8-BA0F-6DEAC603418B" 
	CODEBASE= "/GK/jsp/special/GDSrvZJ.dll#version=1,0,0,2" width="35" height="25"></OBJECT>