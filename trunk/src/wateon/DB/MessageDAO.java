package wateon.DB;

import java.sql.*;
import java.util.Vector;

public class MessageDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs=null;
	
	public boolean insertMessage(MessageDTO dto) {
	
		String query = "insert into message(sender, receiver, message, date) values(?,?,?, sysdate)";
		int result = 0;

		conn = new DBConnector().getConnection();

		try { 
		   pstmt = conn.prepareStatement(query);	
           pstmt.setString(1, dto.getSender());
           pstmt.setString(2, dto.getReceiver()); 
           pstmt.setString(3, dto.getMessage());
		   result = pstmt.executeUpdate();
		} catch (SQLException sqle) {
			System.out.println(sqle.getMessage());		
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (result > 0)	
			return true;
		else
			return false;
	}

	public boolean insertIMessage(MessageDTO dto) {
		
		String query = "insert into imessage(sender, receiver, message, date) values(?,?,?, sysdate)";
		int result = 0;

		conn = new DBConnector().getConnection();

		try { 
		   pstmt = conn.prepareStatement(query);	
           pstmt.setString(1, dto.getSender());
           pstmt.setString(2, dto.getReceiver()); 
           pstmt.setString(3, dto.getMessage());
		   result = pstmt.executeUpdate();
		} catch (SQLException sqle) {
			System.out.println(sqle.getMessage());		
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (result > 0)	
			return true;
		else
			return false;
	}
	
	public Vector<MessageDTO> readSendIMessages(String sender) {

		MessageDTO dto;
		Vector<MessageDTO> v = new Vector<MessageDTO>();
		String query = "select number, sender, receiver, message, date from imessage where sender="+sender;

		conn = new DBConnector().getConnection();
		
		if(conn==null)
			conn = new DBConnector().getConnection();
		
		try {

			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				
				dto = new MessageDTO(rs.getInt("number"), rs.getString("sender"),
						rs.getString("receiver"), rs.getString("message"), rs.getString("date"));
				v.addElement(dto);	
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return v;
	}

	public Vector<MessageDTO> readReceiveIMessages(String receiver) {

		MessageDTO dto;
		Vector<MessageDTO> v = new Vector<MessageDTO>();
		String query = "select number, sender, receiver, message, date from imessage where receiver="+receiver;

		conn = new DBConnector().getConnection();
		
		if(conn==null)
			conn = new DBConnector().getConnection();
		
		try {

			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				
				dto = new MessageDTO(rs.getInt("number"), rs.getString("sender"),
						rs.getString("receiver"), rs.getString("message"), rs.getString("date"));
				v.addElement(dto);	
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return v;
	}

	public Vector<MessageDTO> readMessages(String sender) {

		MessageDTO dto;
		Vector<MessageDTO> v = new Vector<MessageDTO>();
		String query = "select number, sender, receiver, message, date from message where sender="+sender;

		conn = new DBConnector().getConnection();
		
		if(conn==null)
			conn = new DBConnector().getConnection();
		
		try {

			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				
				dto = new MessageDTO(rs.getInt("number"), rs.getString("sender"),
						rs.getString("receiver"), rs.getString("message"), rs.getString("date"));
				v.addElement(dto);	
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return v;
	}

	public void deleteIMessage(int num) {
		
		String query = "delete from imessage where number=?";

		conn = new DBConnector().getConnection();
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, num);
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void deleteMessage(int num) {
		
		String query = "delete from message where number=?";

		conn = new DBConnector().getConnection();
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, num);
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}