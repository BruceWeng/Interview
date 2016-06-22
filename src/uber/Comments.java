package uber;

import java.awt.image.RescaleOp;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.stream.events.StartDocument;

import microsoft.SubArrayMax;

/*
 * �ڶ��֣����˴�硣��ô��һ��source file�����comment�����档���Ʊ�����ӡ���������comment������Ҫ��ӡ���л��߶��е������ ����compile�������������Ի��ǱȽ���˵�������Լ�д������������͡���л���˴���ˮ��
 ���磺
 This is code. // comment1
 This is code.
 /*
 print
 me.
 out.
 ���������Ѱ��//, java��ֱ�ӵ��õ�indexOf("//")�� ��������substring�����е����Ѱ�Һ�  pair, �����м��substring���ҵ�������һ��string������prototype�� public static ArrayList<String> getComments(String str).
 ������ǰ�һ���ļ�ȫ������һ������string�memory�϶����ڲ����õ������follow up���������Ҫ���comments,��Ҫ���comments���ڵ�������û�о���ʵ�֣�����˵��˵���ҵ������Ҫ����ÿ���������ˣ��϶��ܷ��������Իص���ʼ�����⡣��Ϊû�и���������������ʲô��������õ�������ǰ�File�������룬ÿ�ζ�һ�У����������ͺܺñ�����

 �ڶ���MS onsiteҲ�ʹ�������ûд���룬�����˿���string�����"//"��"/*..������ˡ�.��
 ���� String s = "//this is not a comment"; ���code�������������ֻ�Ǹ����ӣ���ʱms�����Թ�˵���кܶ���corner case��
 */
public class Comments {

	public ArrayList<String> getComments(String s) {
		ArrayList<String> res = new ArrayList<String>();
		int singlequote = 0;
		int doublequote = 0;
		int start = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '\'')
				singlequote++;
			else if (s.charAt(i) == '"')
				doublequote++;
			else if (i + 1 < s.length() && singlequote % 2 == 0
					&& doublequote % 2 == 0 && s.charAt(i) == '/') {
				if (s.charAt(i + 1) == '/') {
					start = i;
					int end = s.indexOf("\n", start);
					if (end == -1)
						end = s.length();
					res.add(s.substring(start, end));
					i = end + 1;
				} else if (s.charAt(i + 1) == '*') {
					start = i;
					int end = s.indexOf("*/", start) + 2;
					res.add(s.substring(start, end));
					i = end;
				}
			}
		}
		return res;
	}

	public ArrayList<String> getComments(Reader in) throws IOException {
		ArrayList<String> res = new ArrayList<String>();
		BufferedReader br = new BufferedReader(in);
		String line = null;
		int doublequote = 0;
		int singlequote = 0;
		boolean multilines = false;
		String comment = "";

		while ((line = br.readLine()) != null) {
			for (int i = 0; i < line.length(); i++) {
				if (line.charAt(i) == '\'')
					singlequote++;
				else if (line.charAt(i) == '"')
					doublequote++;
				else if (multilines == false && i + 1 < line.length()
						&& singlequote % 2 == 0 && singlequote % 2 == 0) {
					if (line.charAt(i) == '/') {
						if (line.charAt(i + 1) == '/') {
							res.add(line.substring(i));
							break;
						} else if (line.charAt(i + 1) == '*') {
							int end = line.indexOf("*/");
							if (end == -1) {
								multilines = true;
								comment = line.substring(i);
								break;
							} else {
								comment = line.substring(i, end + 2);
								res.add(comment);
								i = end + 1;
							}
						}
					}
				} else if (multilines) {
					int end = line.indexOf("*/");
					if (end == -1) {
						comment += "\n" + line;
						break;
					} else {
						multilines = false;
						comment += "\n" + line.substring(0, end + 2);
						res.add(comment);
						i = end + 1;
					}
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		Comments q = new Comments();
		System.out
				.println(q
						.getComments(
								"This is code. // comment1 \n /* This is second comment // comment 2*/")
						.toString());
		System.out.println(q.getComments("").toString());
		System.out.println(q.getComments(" This is code. // comment1")
				.toString());
		System.out.println(q.getComments("//").toString());
		System.out
				.println(q
						.getComments(
								"This is code. // comment1 \n This is second comment // comment 2")
						.toString());

		System.out
				.println(q
						.getComments(
								"This is code. // comment1 \n /* This is second comment // comment 2*/ This is third comment // comment 2")
						.toString());
		System.out
				.println(q
						.getComments(
								"This is code. // comment1 \n This is second comment // comment 2 \n /* This is third comment // comment 2*/")
						.toString());
	}
}
