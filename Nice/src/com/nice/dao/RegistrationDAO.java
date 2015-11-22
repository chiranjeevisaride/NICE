package com.nice.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DataSourceUtils;

import com.nice.bean.CloudServer;
import com.nice.bean.FileBean;
import com.nice.bean.FileStatus;
import com.nice.bean.Users;
import com.nice.bean.VirtuvalMachine;
import com.nice.key.CipherExample;
import com.nice.key.CryptMsgUtil;

public class RegistrationDAO {

	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public Boolean registerNewUser(final Users users) {

		String newusersql = "insert into USERLOGIN values((select nvl(max(userid),100)+1 from USERLOGIN),?,?,sysdate,'active',?,?,?)";

		return jdbcTemplate.execute(newusersql,
				new PreparedStatementCallback<Boolean>() {

					@Override
					public Boolean doInPreparedStatement(PreparedStatement ps)
							throws SQLException, DataAccessException {

						ps.setString(1, users.getLoginid());
						ps.setString(2, users.getPassword());
						ps.setString(3, users.getLogintype());
						ps.setString(4, users.getLocation());
						ps.setString(5, users.getMailid());

						return ps.execute();
					}

				});

	}

	public Boolean createCloudServer(final CloudServer cloudServer) {
		String newusersql = "insert into CLOUDSERVER values((select nvl(max(CLOUDSERVERID),100)+1 from CLOUDSERVER),?,?,?,?,'normal',10000,sysdate)";

		return jdbcTemplate.execute(newusersql,
				new PreparedStatementCallback<Boolean>() {

					@Override
					public Boolean doInPreparedStatement(PreparedStatement ps)
							throws SQLException, DataAccessException {

						ps.setString(1, cloudServer.getName());
						ps.setString(2, cloudServer.getVirtualip());
						ps.setString(3, cloudServer.getPort());
						ps.setString(4, cloudServer.getRegion());

						return ps.execute();
					}

				});
	}

	public Boolean createVirtuvalMachines(final VirtuvalMachine serverNodes) {
		String newusersql = "insert into VIRTUVALMACHINE values((select nvl(max(SERVERNODEID),100)+1 from VIRTUVALMACHINE),?,?,?,?,'normal',?,sysdate,?,?,?,?,?,?)";

		return jdbcTemplate.execute(newusersql,
				new PreparedStatementCallback<Boolean>() {

					@Override
					public Boolean doInPreparedStatement(PreparedStatement ps)
							throws SQLException, DataAccessException {
						ps.setString(1, serverNodes.getBalancerName());
						ps.setString(2, serverNodes.getName());
						ps.setString(3, serverNodes.getVirtualip());
						ps.setString(4, serverNodes.getPort());
						ps.setString(5, serverNodes.getCpuCapacity());
						ps.setString(6, serverNodes.getRegion());
						ps.setString(7, serverNodes.getBandWidth());
						ps.setString(8, serverNodes.getCost());
						ps.setString(9, serverNodes.getVmowner());
						ps.setString(10, serverNodes.getFrequency());
						ps.setString(11, serverNodes.getThreshold());
						return ps.execute();
					}

				});
	}

	public Users loginCheck(Users users) {
		String query = "select * from userlogin where loginid='"
				+ users.getLoginid() + "' and password='" + users.getPassword()
				+ "' and logintype='" + users.getLogintype().toLowerCase()
				+ "'";
		System.out.println(query);
		return jdbcTemplate.query(query, new ResultSetExtractor<Users>() {
			public Users extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				Users user = new Users();
				if (rs.next()) {
					user.setUserid(rs.getInt(1));
					user.setLoginid(rs.getString(2));
					user.setRegistereddate(rs.getDate(4).toString());
					user.setLogintype(rs.getString(6));
					user.setLocation(rs.getString(7));
					user.setMailid(rs.getString(8));
				}
				return user;
			}
		});
	}

	public Object[][] viewCloudServers() {
		return jdbcTemplate.query(
				"select * from CLOUDSERVER order by CLOUDSERVERID",
				new ResultSetExtractor<Object[][]>() {
					String s = "{";

					public Object[][] extractData(ResultSet rs)
							throws SQLException, DataAccessException {
						System.out.println(rs.getFetchSize());

						Object obj[][] = new Object[100][8];
						int i = 0;
						while (rs.next()) {

							obj[i][0] = rs.getString(2);
							obj[i][1] = rs.getString(3);
							obj[i][2] = rs.getString(4);
							obj[i][3] = rs.getString(5);
							obj[i][4] = rs.getString(6);
							obj[i][5] = rs.getInt(7);
							obj[i][6] = String.valueOf(rs.getDate(8));

							i++;
						}

						return obj;
					}
				});

	}

	public Object[][] viewVirtuvalMachines(String cloudServerName) {
		return jdbcTemplate.query(
				"select * from VIRTUVALMACHINE where CLOUDSERVERNAME='"
						+ cloudServerName + "' order by SERVERNODEID",
				new ResultSetExtractor<Object[][]>() {
					String s = "{";

					public Object[][] extractData(ResultSet rs)
							throws SQLException, DataAccessException {
						System.out.println(rs.getFetchSize());

						Object obj[][] = new Object[100][9];
						int i = 0;
						while (rs.next()) {

							obj[i][0] = rs.getString(3);
							obj[i][1] = rs.getString(4);
							obj[i][2] = rs.getString(5);
							obj[i][3] = rs.getString(6);
							obj[i][4] = rs.getString(7);
							obj[i][5] = String.valueOf(rs.getDate(8));
							obj[i][6] = rs.getString(9);
							obj[i][7] = rs.getString(10);
							obj[i][8] = rs.getString(11);

							i++;
						}

						return obj;
					}
				});

	}

	public Object[][] viewUploadFiles(String loginid) {
		return jdbcTemplate.query("select * from FILEDETAILS where vmowner='"
				+ loginid + "'", new ResultSetExtractor<Object[][]>() {
			String s = "{";

			public Object[][] extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				Object obj[][] = new Object[100][8];
				int i = 0;
				while (rs.next()) {
					obj[i][0] = rs.getInt(1);
					obj[i][1] = rs.getString(2);
					obj[i][2] = String.valueOf(rs.getDate(3));
					obj[i][3] = rs.getString(4);
					obj[i][4] = rs.getString(6);
					obj[i][5] = rs.getString(7);
					obj[i][6] = rs.getString(8);
					obj[i][7] = rs.getString(10);
					i++;
				}
				return obj;
			}
		});
	}

	public Object[][] viewAllUploadFiles() {
		return jdbcTemplate.query("select * from FILEDETAILS",
				new ResultSetExtractor<Object[][]>() {
					String s = "{";

					public Object[][] extractData(ResultSet rs)
							throws SQLException, DataAccessException {
						Object obj[][] = new Object[100][8];
						int i = 0;
						while (rs.next()) {
							obj[i][0] = rs.getInt(1);
							obj[i][1] = rs.getString(2);
							obj[i][2] = String.valueOf(rs.getDate(3));
							obj[i][3] = rs.getString(4);
							obj[i][4] = rs.getString(6);
							obj[i][5] = rs.getInt(7)
									+ "-"
									+ FileStatus.getFileStatus().get(
											rs.getInt(7));
							obj[i][6] = rs.getString(8);
							obj[i][7] = rs.getString(10);
							i++;
						}
						return obj;
					}
				});
	}

	public Object[][] viewFileUploadFiles(String filename) {
		return jdbcTemplate.query(
				"select * from ATTACKERFILEDETAILS where FILENAME='" + filename
						+ "' order by id",
				new ResultSetExtractor<Object[][]>() {
					String s = "{";

					public Object[][] extractData(ResultSet rs)
							throws SQLException, DataAccessException {
						Object obj[][] = new Object[100][7];
						int i = 0;
						while (rs.next()) {
							obj[i][0] = rs.getInt(1);
							obj[i][1] = rs.getString(2);
							obj[i][2] = rs.getInt(3);
							obj[i][3] = rs.getString(4);
							obj[i][4] = String.valueOf(rs.getDate(5));
							obj[i][5] = rs.getInt(6);
							obj[i][6] = rs.getInt(7);

							i++;
						}
						return obj;
					}
				});
	}

	public Vector<Object[][]> viewVectorFileUploadFiles(String filename) {
		final Vector<Object[][]> vObjects = new Vector<Object[][]>();
		return jdbcTemplate.query(
				"select * from ATTACKERFILEDETAILS where FILENAME='" + filename
						+ "' order by id",
				new ResultSetExtractor<Vector<Object[][]>>() {
					String s = "{";

					public Vector<Object[][]> extractData(ResultSet rs)
							throws SQLException, DataAccessException {
						Object obj[][] = new Object[100][7];
						int i = 0;
						while (rs.next()) {
							obj[i][0] = rs.getInt(1);
							obj[i][1] = rs.getString(2);
							obj[i][2] = rs.getInt(3);
							obj[i][3] = rs.getString(4);
							obj[i][4] = String.valueOf(rs.getDate(5));

							obj[i][5] = rs.getInt(6);
							obj[i][6] = rs.getInt(7);
							vObjects.add(obj);
							i++;
						}
						return vObjects;
					}
				});
	}

	public Vector<Object[][]> viewCloudUploadFiles(String cloudname) {
		Vector<Object[][]> vObjects = null;
		Vector<Object[][]> vObjects1 = new Vector<Object[][]>();
		String vmnames[] = viewVirtuvalMachineNames(cloudname).split(",");
		for (int i = 0; i < vmnames.length; i++) {
			vObjects = viewVMUploadFiles(vmnames[i]);
			vObjects1.addAll(vObjects);
		}
		return vObjects1;
	}

	public Vector<Object[][]> viewVMUploadFiles(String vm) {
		Vector<Object[][]> vObjects = new Vector<Object[][]>();
		Object[][] obj = null;
		String vmfilenames[] = viewVirtuvalMeachineFiles(vm).split(",");
		for (int i = 0; i < vmfilenames.length; i++) {
			obj = viewFileUploadFiles(vmfilenames[i]);
			vObjects.add(obj);
		}
		return vObjects;
	}

	public String viewCloudServerNames() {
		return jdbcTemplate.query(
				"select * from CLOUDSERVER order by CLOUDSERVERID",
				new ResultSetExtractor<String>() {
					String s = "";

					public String extractData(ResultSet rs)
							throws SQLException, DataAccessException {
						while (rs.next()) {
							s = s + rs.getString(2) + ",";
						}
						return s;
					}
				});
	}

	public String viewVMOnwers() {
		return jdbcTemplate
				.query(
						"select loginid from USERLOGIN where USERLOGIN.loginid not in (select distinct vmowner from VIRTUVALMACHINE) and LOGINTYPE='vmowner' order by USERID",
						new ResultSetExtractor<String>() {
							String s = "";

							public String extractData(ResultSet rs)
									throws SQLException, DataAccessException {
								while (rs.next()) {
									s = s + rs.getString(1) + ",";
								}
								return s;
							}
						});

	}

	public String viewAllVMOnwers() {
		return jdbcTemplate.query(
				"select distinct vmowner from VIRTUVALMACHINE",
				new ResultSetExtractor<String>() {
					String s = "";

					public String extractData(ResultSet rs)
							throws SQLException, DataAccessException {
						while (rs.next()) {
							s = s + rs.getString(1) + ",";
						}
						return s;
					}
				});

	}

	public String viewVirtuvalMachineNames(String cloudServerName) {
		return jdbcTemplate.query(
				"select * from VIRTUVALMACHINE where CLOUDSERVERNAME='"
						+ cloudServerName + "' order by SERVERNODEID",
				new ResultSetExtractor<String>() {
					String s = "";

					public String extractData(ResultSet rs)
							throws SQLException, DataAccessException {
						while (rs.next()) {
							s = s + rs.getString(3) + ",";
						}
						return s;
					}
				});

	}

	public String viewVirtuvalMachineNames() {
		return jdbcTemplate.query(
				"select * from VIRTUVALMACHINE order by SERVERNODEID",
				new ResultSetExtractor<String>() {
					String s = "";

					public String extractData(ResultSet rs)
							throws SQLException, DataAccessException {
						while (rs.next()) {
							s = s + rs.getString(3) + ",";
						}
						return s;
					}
				});

	}

	public String viewServerFiles() {
		return jdbcTemplate.query("select * from FILEDETAILS",
				new ResultSetExtractor<String>() {
					String s = "";

					public String extractData(ResultSet rs)
							throws SQLException, DataAccessException {
						while (rs.next()) {
							s = s + rs.getString(2) + ",";
						}
						return s;
					}
				});

	}

	public String viewVirtuvalMeachineFiles(String vmname) {
		return jdbcTemplate.query("select * from FILEDETAILS where VMNAME='"
				+ vmname + "'", new ResultSetExtractor<String>() {
			String s = "";

			public String extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				while (rs.next()) {
					s = s + rs.getString(2) + ",";
				}
				return s;
			}
		});

	}

	public Boolean deleteServerNodes(final String serverName)
			throws FileNotFoundException, IOException {
		String cloudfilesql = "delete VIRTUVALMACHINE where SERVERNAME=?";

		return jdbcTemplate.execute(cloudfilesql,
				new PreparedStatementCallback<Boolean>() {

					@Override
					public Boolean doInPreparedStatement(PreparedStatement ps)
							throws SQLException, DataAccessException {
						ps.setString(1, serverName.trim());
						return ps.execute();
					}

				});
	}

	public Object[] viewCloudServerMetaData() {
		return jdbcTemplate.query(
				"select * from CLOUDSERVER order by CLOUDSERVERID",
				new ResultSetExtractor<Object[]>() {
					public Object[] extractData(ResultSet rs)
							throws SQLException, DataAccessException {

						ResultSetMetaData resultSetMetaData = rs.getMetaData();

						String tablemetadata[] = new String[] {
								resultSetMetaData.getColumnName(2),
								resultSetMetaData.getColumnName(3),
								resultSetMetaData.getColumnName(4),
								resultSetMetaData.getColumnName(5),
								resultSetMetaData.getColumnName(6),
								resultSetMetaData.getColumnName(7),
								resultSetMetaData.getColumnName(8) };

						return tablemetadata;
					}
				});
	}

	public Object[] fileDetailsMetaData(String filename) {

		int fileid = getFileId(filename);
		return jdbcTemplate.query(
				"select * from FILEUPLOADDETAILS where fileid=" + fileid
						+ " order by ORDERID",
				new ResultSetExtractor<Object[]>() {
					public Object[] extractData(ResultSet rs)
							throws SQLException, DataAccessException {

						ResultSetMetaData resultSetMetaData = rs.getMetaData();

						String tablemetadata[] = new String[] {
								resultSetMetaData.getColumnName(3),
								resultSetMetaData.getColumnName(5),
								resultSetMetaData.getColumnName(4),
								resultSetMetaData.getColumnName(7), };

						return tablemetadata;
					}
				});
	}

	public Object[] viewVirtuvalMachineMetaData() {
		return jdbcTemplate.query(
				"select * from VIRTUVALMACHINE order by SERVERNODEID",
				new ResultSetExtractor<Object[]>() {
					public Object[] extractData(ResultSet rs)
							throws SQLException, DataAccessException {

						ResultSetMetaData resultSetMetaData = rs.getMetaData();

						String tablemetadata[] = new String[] {
								resultSetMetaData.getColumnName(3),
								resultSetMetaData.getColumnName(4),
								resultSetMetaData.getColumnName(5),
								resultSetMetaData.getColumnName(6),
								resultSetMetaData.getColumnName(7),
								resultSetMetaData.getColumnName(8),
								resultSetMetaData.getColumnName(9),
								resultSetMetaData.getColumnName(10),
								resultSetMetaData.getColumnName(11) };

						return tablemetadata;
					}
				});
	}

	public Object[] viewUplaodFileMetaData() {
		return jdbcTemplate.query("select * from FILEDETAILS",
				new ResultSetExtractor<Object[]>() {
					public Object[] extractData(ResultSet rs)
							throws SQLException, DataAccessException {

						ResultSetMetaData resultSetMetaData = rs.getMetaData();

						String tablemetadata[] = new String[] {
								resultSetMetaData.getColumnName(1),
								resultSetMetaData.getColumnName(2),
								resultSetMetaData.getColumnName(3),
								resultSetMetaData.getColumnName(4),
								resultSetMetaData.getColumnName(6),
								resultSetMetaData.getColumnName(7),
								resultSetMetaData.getColumnName(8),
								resultSetMetaData.getColumnName(10) };

						return tablemetadata;
					}
				});
	}

	public String uploadCloudFile(FileBean fileBean) {
		Connection con = null;
		boolean flag = false;
		String vmname = getVMname(fileBean.getVmowner());
		try {
			ApplicationContext ctx = new ClassPathXmlApplicationContext(
					"applicationContext.xml");
			DataSource ds = (DataSource) ctx.getBean("ds");
			// Open a database connection using Spring's DataSourceUtils
			con = DataSourceUtils.getConnection(ds);
			PreparedStatement filedetailspreparedStatement = con
					.prepareStatement("insert into filedetails values((select nvl(max(fileid),100)+1 from filedetails),?,sysdate,?,?,?,0,?,?,?)");
			File f = new File(fileBean.getFilename());
			filedetailspreparedStatement.setString(1, f.getName());
			filedetailspreparedStatement.setInt(2, (int) f.length());
			String enc = new CipherExample().encrypt(fileBean.getKey(),
					fileBean.getFilename());
			File ff = new File(enc);
			FileInputStream fileInputStream = new FileInputStream(ff);
			filedetailspreparedStatement.setBinaryStream(3, fileInputStream,
					(int) ff.length());
			filedetailspreparedStatement.setString(4, fileBean.getKey());
			filedetailspreparedStatement.setString(5, fileBean.getSignature());
			filedetailspreparedStatement.setString(6, fileBean.getVmowner());
			filedetailspreparedStatement.setString(7, vmname);
			filedetailspreparedStatement.executeUpdate();
			flag = true;
			// preparedStatement.executeUpdate();
		} catch (Exception e) {
			try {
				System.out.println(e);
				con.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return vmname;
	}

	public int getFileId(String file) {
		return jdbcTemplate.query(
				"select fileid from FILEDETAILS where filename='" + file.trim()
						+ "'", new ResultSetExtractor<Integer>() {
					int s = 0;

					public Integer extractData(ResultSet rs)
							throws SQLException, DataAccessException {
						if (rs.next()) {
							s = rs.getInt(1);
						}
						return s;
					}
				});

	}

	public String getVMname(String ownername) {
		return jdbcTemplate.query(
				"select vmname from VIRTUVALMACHINE where VMOWNER='"
						+ ownername.trim() + "'",
				new ResultSetExtractor<String>() {
					String s = "";

					public String extractData(ResultSet rs)
							throws SQLException, DataAccessException {
						if (rs.next()) {
							s = rs.getString(1);
						}
						return s;
					}
				});
	}

	public List<CloudServer> viewCloudFile(String file) {
		int fileid = getFileId(file);
		System.out.println("----------------------------" + fileid);
		return jdbcTemplate.query(
				"select * from fileuploaddetails where fileid=" + fileid
						+ " order by orderid", new RowMapper<CloudServer>() {
					public CloudServer mapRow(ResultSet rs, int rownumber)
							throws SQLException {
						CloudServer loadBalancer = new CloudServer();
						loadBalancer.setUploadid(rs.getInt(1));
						loadBalancer.setFileid(rs.getInt(2));
						loadBalancer.setOrderid(rs.getInt(3));

						loadBalancer.setBalancername(rs.getString(5));
						loadBalancer.setServername(rs.getString(4));
						loadBalancer.setFilesize(rs.getInt(7));
						return loadBalancer;
					}

				});

	}

	public Object[] viewCloudMetaData() {
		return jdbcTemplate.query(
				"select * from CLOUDFILEDATA order by FILEDATAID",
				new ResultSetExtractor<Object[]>() {
					public Object[] extractData(ResultSet rs)
							throws SQLException, DataAccessException {

						ResultSetMetaData resultSetMetaData = rs.getMetaData();

						String tablemetadata[] = new String[] {
								resultSetMetaData.getColumnName(1),
								resultSetMetaData.getColumnName(2),
								resultSetMetaData.getColumnName(3),
								resultSetMetaData.getColumnName(4),
								resultSetMetaData.getColumnName(5),
								resultSetMetaData.getColumnName(6),
								resultSetMetaData.getColumnName(9),
								resultSetMetaData.getColumnName(10),
								resultSetMetaData.getColumnName(11), };

						return tablemetadata;
					}
				});
	}

	public String downloadFile(final String filename)
			throws FileNotFoundException, IOException {
		return jdbcTemplate.query("select * from FILEDETAILS where filename='"
				+ filename.trim() + "'", new ResultSetExtractor<String>() {
			public String extractData(ResultSet rs) throws SQLException,
					DataAccessException {

				String path = new File(".").getAbsolutePath();
				boolean b = new File(path + "\\dec").mkdir();
				File file = new File(new File("dec") + "\\" + filename);
				FileOutputStream fileOutputStream = null;
				try {
					fileOutputStream = new FileOutputStream(file);
					byte[] buffer = new byte[1];
					if (rs.next()) {
						InputStream is = rs.getBinaryStream(5);
						while (is.read(buffer) > 0) {
							fileOutputStream.write(buffer);
						}
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String decfile = null;
				try {
					decfile = new CipherExample().decrypt(rs.getString(6), file
							.toString());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return decfile;
			}
		});
	}

	public FileBean attackerDownloadFile(final String filename,
			String attackername) throws FileNotFoundException, IOException {
		final FileBean fileBean = new FileBean();
		fileBean.setFilename(new File(filename).getName().toString());
		fileBean.setAttackername(attackername);
		final int filestatus = getFileStatus(filename);
		if (filestatus == 0) {
			int status = getFileStatusChange(filename, filestatus + 1);
			return jdbcTemplate.query(
					"select * from FILEDETAILS where filename='"
							+ filename.trim() + "'",
					new ResultSetExtractor<FileBean>() {
						public FileBean extractData(ResultSet rs)
								throws SQLException, DataAccessException {
							String path = new File(".").getAbsolutePath();
							boolean b = new File(path + "\\dec").mkdir();
							File file = new File(new File("dec") + "\\"
									+ filename);
							FileOutputStream fileOutputStream = null;
							try {
								fileOutputStream = new FileOutputStream(file);
								byte[] buffer = new byte[1];
								if (rs.next()) {
									fileBean.setFileactualsize(rs.getInt(4));
									int downloadsize = rs.getInt(4) / 10;
									fileBean.setFiledownloadsize(rs.getInt(4)
											- downloadsize);
									fileBean
											.setLossofpackets(downloadsize / 10);
									InputStream is = rs.getBinaryStream(5);
									int i = 0;
									while (is.read(buffer) > 0) {
										fileOutputStream.write(buffer);
										++i;
										if (i == fileBean.getFiledownloadsize()) {
											break;
										}
									}
								}
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							String decfile = null;
							try {
								decfile = new CipherExample().decrypt(rs
										.getString(6), file.toString());
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							fileBean.setDecfilename(decfile);
							int filestatus = attackerFileDetails(fileBean);

							return fileBean;
						}
					});
		} else {
			int status = getFileStatusChange(filename, filestatus + 1);
			return jdbcTemplate.query(
					"select * from FILEDETAILS where filename='"
							+ filename.trim() + "'",
					new ResultSetExtractor<FileBean>() {
						public FileBean extractData(ResultSet rs)
								throws SQLException, DataAccessException {
							String path = new File(".").getAbsolutePath();
							boolean b = new File(path + "\\dec").mkdir();
							File file = new File(new File("dec") + "\\"
									+ filename);
							FileOutputStream fileOutputStream = null;
							try {
								fileOutputStream = new FileOutputStream(file);
								byte[] buffer = new byte[1];
								if (rs.next()) {
									fileBean.setFileactualsize(rs.getInt(4));
									int downloadsize = rs.getInt(4) / 10;
									fileBean.setFiledownloadsize(rs.getInt(4)
											- (downloadsize * filestatus));
									fileBean
											.setLossofpackets(downloadsize / 10);
									InputStream is = rs.getBinaryStream(5);
									int i = 0;
									while (is.read(buffer) > 0) {
										fileOutputStream.write(buffer);
										++i;
										if (i == fileBean.getFiledownloadsize()) {
											break;
										}
									}
								}
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							String decfile = null;
							try {
								decfile = new CipherExample().decrypt(rs
										.getString(6), file.toString());
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							fileBean.setDecfilename(decfile);
							int filestatus = attackerFileDetails(fileBean);

							return fileBean;
						}
					});

		}
	}

	public Boolean deleteFile(final String filename, final String key)
			throws FileNotFoundException, IOException {
		String cloudfilesql = "delete CLOUDFILEDATA where FILENAME=?";

		return jdbcTemplate.execute(cloudfilesql,
				new PreparedStatementCallback<Boolean>() {

					@Override
					public Boolean doInPreparedStatement(PreparedStatement ps)
							throws SQLException, DataAccessException {
						ps.setString(1, filename.trim());
						return ps.execute();
					}

				});
	}

	public Integer changeServerStatus(final String status,
			final String servername) throws FileNotFoundException, IOException {
		String changestatus = "Update CLOUDSERVER set SERVERRSTATUS='" + status
				+ "' where SERVERNAME='" + servername + "'";

		return jdbcTemplate.execute(changestatus,
				new PreparedStatementCallback<Integer>() {

					@Override
					public Integer doInPreparedStatement(PreparedStatement ps)
							throws SQLException, DataAccessException {
						return ps.executeUpdate();
					}

				});
	}

	public Integer changeServerNodeStatus(final String status,
			final String servername) throws FileNotFoundException, IOException {
		String changestatus = "Update VIRTUVALMACHINE set VMSTATUS='" + status
				+ "' where VMNAME='" + servername + "'";

		return jdbcTemplate.execute(changestatus,
				new PreparedStatementCallback<Integer>() {

					@Override
					public Integer doInPreparedStatement(PreparedStatement ps)
							throws SQLException, DataAccessException {
						return ps.executeUpdate();
					}

				});
	}

	public Boolean changeStatus(int groupid, final String groupname) {

		return jdbcTemplate
				.query(
						"select (select USERLOGIN.loginid from USERLOGIN where userid=GROUPUSERS.userid) from GROUPUSERS where groupid="
								+ groupid, new ResultSetExtractor<Boolean>() {
							public Boolean extractData(ResultSet rs)
									throws SQLException, DataAccessException {
								while (rs.next()) {
									try {
										System.out.println("aaaaa"
												+ new File(groupname)
														.getAbsolutePath());
										boolean path = new File(new File(
												groupname).getAbsolutePath()
												+ "\\" + rs.getString(1))
												.mkdir();

										createCloudFile(rs.getString(1),
												new File(groupname)
														.getAbsolutePath()
														+ "\\"
														+ rs.getString(1));
									} catch (Exception e) {
										e.printStackTrace();
									}
								}
								return true;
							}
						});

	}

	public Boolean createCloudFile(final String filename, final String filepath)
			throws FileNotFoundException, IOException {
		System.out.println(filename);
		System.out.println(filepath);

		return jdbcTemplate.query(
				"select * from CLOUDFILEDATA where username='"
						+ filename.trim() + "'",
				new ResultSetExtractor<Boolean>() {
					public Boolean extractData(ResultSet rs)
							throws SQLException, DataAccessException {
						try {
							while (rs.next()) {

								File file = new File(filepath + "\\"
										+ rs.getString(5));
								FileOutputStream fileOutputStream = null;
								fileOutputStream = new FileOutputStream(file);
								byte[] buffer = new byte[1];
								InputStream is = rs.getBinaryStream(7);
								while (is.read(buffer) > 0) {
									fileOutputStream.write(buffer);
								}
							}
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

						return true;
					}
				});
	}

	public Integer viewPraposedSignaturesCount() {
		return jdbcTemplate.query("select count(*) from  groups",
				new ResultSetExtractor<Integer>() {
					Integer s = 0;

					public Integer extractData(ResultSet rs)
							throws SQLException, DataAccessException {
						if (rs.next()) {
							s = rs.getInt(1);
						}
						return s;
					}
				});
	}

	public Vector<CloudServer> viewUploadedFutureFileGraph(String filename) {
		int fileid = getFileId(filename);
		return jdbcTemplate
				.query(
						"select balancername,COUNT(balancername) AS NumberOfTimes from FILEUPLOADDETAILS where fileid="
								+ fileid
								+ " group by balancername order by balancername",
						new ResultSetExtractor<Vector<CloudServer>>() {
							Integer s = 0;
							Vector<CloudServer> vectorlBalancers = new Vector<CloudServer>();
							CloudServer loadBalancer;

							public Vector<CloudServer> extractData(ResultSet rs)
									throws SQLException, DataAccessException {
								while (rs.next()) {
									loadBalancer = new CloudServer();
									loadBalancer.setBalancername(rs
											.getString(1));
									loadBalancer.setFilesize(rs.getInt(2));
									vectorlBalancers.add(loadBalancer);
								}
								return vectorlBalancers;
							}
						});
	}

	public Vector<CloudServer> viewUploadedFileGraph(String filename) {
		int fileid = getFileId(filename);
		return jdbcTemplate
				.query(
						"select balancername,COUNT(balancername) AS NumberOfTimes from FILEUPLOADDETAILS where fileid="
								+ fileid
								+ " group by balancername order by NumberOfTimes",
						new ResultSetExtractor<Vector<CloudServer>>() {
							Integer s = 0;
							Vector<CloudServer> vectorlBalancers = new Vector<CloudServer>();
							CloudServer loadBalancer;

							public Vector<CloudServer> extractData(ResultSet rs)
									throws SQLException, DataAccessException {
								while (rs.next()) {
									loadBalancer = new CloudServer();
									loadBalancer.setBalancername(rs
											.getString(1));
									loadBalancer.setFilesize(rs.getInt(2));
									vectorlBalancers.add(loadBalancer);
								}
								return vectorlBalancers;
							}
						});
	}

	public Users getTaskProcessingDetails(String string) {
		Connection con = null;
		Users user = new Users();
		try {

			ApplicationContext ctx = new ClassPathXmlApplicationContext(
					"applicationContext.xml");
			DataSource ds = (DataSource) ctx.getBean("ds");
			// Open a database connection using Spring's DataSourceUtils
			con = DataSourceUtils.getConnection(ds);
			PreparedStatement preparedStatement = con
					.prepareStatement("SELECT CLOUDSERVERNAME,VMSTATUS, COUNT(VMSTATUS) AS NumberOfTimes FROM VIRTUVALMACHINE where VMSTATUS='normal' OR VMSTATUS='idle' GROUP BY CLOUDSERVERNAME,VMSTATUS HAVING (COUNT(VMSTATUS)>1) ORDER BY NumberOfTimes DESC");
			ResultSet balancerstatus = preparedStatement.executeQuery();

			if (balancerstatus.next()) {
				String balancername = balancerstatus.getString(1);
				String status = balancerstatus.getString(2);
				if (status.equals("idle") || status.equals("normal")) {

					PreparedStatement servernodepreparedStatement = con
							.prepareStatement("select * from VIRTUVALMACHINE where CLOUDSERVERNAME='"
									+ balancername
									+ "' and (VMSTATUS='normal' OR VMSTATUS='idle') order by VMCPUCAPACITY desc,IOBANDWIDTH desc");
					ResultSet servernoderesultset = servernodepreparedStatement
							.executeQuery();
					if (servernoderesultset.next()) {
						user.setCloudservername(servernoderesultset
								.getString(2));
						user.setVirtuvalmachine(servernoderesultset
								.getString(3));
						user.setDownloadcost(servernoderesultset.getInt(11));
						user.setBandwidth(servernoderesultset.getInt(10));
						user.setVmcapacity(servernoderesultset.getInt(7));

					}
				}
			}
			// preparedStatement.executeUpdate();
		} catch (Exception e) {
			try {
				System.out.println(e);
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return user;
	}

	public int getFileLength(String file) {
		return jdbcTemplate.query(
				"select FILESIZE from FILEDETAILS where filename='"
						+ file.trim() + "'", new ResultSetExtractor<Integer>() {
					int s = 0;

					public Integer extractData(ResultSet rs)
							throws SQLException, DataAccessException {
						if (rs.next()) {
							s = rs.getInt(1);
						}
						return s;
					}
				});
	}

	public int getFileStatusChange(String filename, int status) {
		String changestatus = "Update FILEDETAILS set FILESTATUS=" + status
				+ " where filename='" + filename.trim() + "'";

		return jdbcTemplate.execute(changestatus,
				new PreparedStatementCallback<Integer>() {

					@Override
					public Integer doInPreparedStatement(PreparedStatement ps)
							throws SQLException, DataAccessException {
						return ps.executeUpdate();
					}

				});

	}

	public int attackerFileDetails(FileBean fileBean) {
		String changestatus = "insert into ATTACKERFILEDETAILS values((select nvl(max(id),0)+1 from ATTACKERFILEDETAILS),"
				+ "'"
				+ fileBean.getFilename()
				+ "',"
				+ fileBean.getLossofpackets()
				+ ",'"
				+ fileBean.getAttackername()
				+ "',sysdate,"
				+ fileBean.getFileactualsize()
				+ ","
				+ fileBean.getFiledownloadsize() + ")";

		return jdbcTemplate.execute(changestatus,
				new PreparedStatementCallback<Integer>() {

					@Override
					public Integer doInPreparedStatement(PreparedStatement ps)
							throws SQLException, DataAccessException {
						return ps.executeUpdate();
					}

				});

	}

	public int getFileStatus(String filename) {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(
				"select FILESTATUS from FILEDETAILS where filename='"
						+ filename.trim() + "'",
				new ResultSetExtractor<Integer>() {
					int s = 0;

					public Integer extractData(ResultSet rs)
							throws SQLException, DataAccessException {
						if (rs.next()) {
							s = rs.getInt(1);
						}
						return s;
					}
				});
	}

	public String getKey(String filename) {
		return jdbcTemplate.query(
				"select ENCRYPTEDKEY from FILEDETAILS where filename='"
						+ filename.trim() + "'",
				new ResultSetExtractor<String>() {
					String s = "";

					public String extractData(ResultSet rs)
							throws SQLException, DataAccessException {
						if (rs.next()) {
							s = rs.getString(1);
						}
						return s;
					}
				});
	}

	public Boolean uploadCloudFile(String filename) {
		Connection con = null;
		boolean flag = false;
		try {
			ApplicationContext ctx = new ClassPathXmlApplicationContext(
					"applicationContext.xml");
			DataSource ds = (DataSource) ctx.getBean("ds");
			// Open a database connection using Spring's DataSourceUtils
			con = DataSourceUtils.getConnection(ds);
			PreparedStatement filedetailspreparedStatement = con
					.prepareStatement("insert into filedetails values((select nvl(max(fileid),100)+1 from filedetails),?,sysdate,?,?,?,'false')");

			File f = new File(filename);
			filedetailspreparedStatement.setString(1, f.getName());
			filedetailspreparedStatement.setInt(2, (int) f.length());

			CryptMsgUtil decrypt = new CryptMsgUtil(f.getName());
			String key = decrypt.encrypt(f.getName());

			String enc = new CipherExample().encrypt(key, filename);
			File ff = new File(enc);
			FileInputStream fileInputStream = new FileInputStream(ff);
			filedetailspreparedStatement.setBinaryStream(3, fileInputStream,
					(int) ff.length());
			filedetailspreparedStatement.setString(4, key);
			filedetailspreparedStatement.executeUpdate();

			flag = true;
			// preparedStatement.executeUpdate();
		} catch (Exception e) {
			try {
				System.out.println(e);
				con.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		return flag;
	}

	public int preventFileUploadFiles(String filename) {
		String changestatus = "Update FILEDETAILS set FILESTATUS=0 where filename='"
				+ filename.trim() + "'";

		return jdbcTemplate.execute(changestatus,
				new PreparedStatementCallback<Integer>() {

					@Override
					public Integer doInPreparedStatement(PreparedStatement ps)
							throws SQLException, DataAccessException {
						return ps.executeUpdate();
					}

				});
	}

	public int preventCloudUploadFiles(String cloudname) {
		int vObjects = 0;
		String vmnames[] = viewVirtuvalMachineNames(cloudname).split(",");
		for (int i = 0; i < vmnames.length; i++) {
			vObjects = preventVMUploadFiles(vmnames[i]);
		}
		return vObjects;
	}

	public int preventVMUploadFiles(String vm) {
		Vector<Object[][]> vObjects = new Vector<Object[][]>();
		int obj = 0;
		String vmfilenames[] = viewVirtuvalMeachineFiles(vm).split(",");
		for (int i = 0; i < vmfilenames.length; i++) {
			obj = preventFileUploadFiles(vmfilenames[i]);

		}
		return obj;
	}
}
