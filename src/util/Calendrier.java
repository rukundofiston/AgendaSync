//**********************************************************************
// Package
//**********************************************************************

package util;

//**********************************************************************
// Import list
//**********************************************************************

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.Border;

import org.freixas.jcalendar.DateEvent;
import org.freixas.jcalendar.DateListener;
import org.freixas.jcalendar.JCalendar;

import view.ListAppointmentView;
import view.AppointmentView;;

/**
 * This example shows various instances of the JCalendar class.
 * <hr>
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the Artistic License. You should have
 * received a copy of the Artistic License along with this program. If
 * not, a copy is available at
 * <a href="http://opensource.org/licenses/artistic-license.php">
 * opensource.org</a>.
 *
 * @author Antonio Freixas
 */

// Copyright © 2004 Antonio Freixas
// All Rights Reserved.

public class Calendrier extends JFrame{
	private static final long serialVersionUID = 1L;
	/**
	 * Create various instances of a JCalendar.
	 */

	public Calendrier(){
		// Set up the frame
		setTitle("Calendrier");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		Container contentPane = getContentPane();
		contentPane.setLayout(null);

		// Create a border for all calendars

		Border etchedBorder =
				BorderFactory.createEtchedBorder();
		Border emptyBorder =
				BorderFactory.createEmptyBorder(10, 10, 10, 10);
		Border compoundBorder =
				BorderFactory.createCompoundBorder(etchedBorder, emptyBorder);

		// Display date and time using the default calendar and locale.
		// Display today's date at the bottom.

		JCalendar calendar1 =
				new JCalendar(
						JCalendar.DISPLAY_DATE | JCalendar.DISPLAY_TIME,
						true);
		calendar1.addDateListener(new DateListener(){
			
			public void dateChanged(DateEvent e)
			{
				Calendar c = e.getSelectedDate();
				if (c != null) {
					Calendrier.this.setVisible(false);
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					AppointmentView.date = sdf.format(c.getTime());
					AppointmentView.lblDate.setText(sdf.format(c.getTime()));
					System.out.println(sdf.format(c.getTime()));
				}
				else {
					System.out.println("No time selected.");
				}
			}
		});
		calendar1.setBorder(compoundBorder);

		// Set fonts rather than using defaults

		calendar1.setTitleFont(new Font("Serif", Font.BOLD|Font.ITALIC, 24));
		calendar1.setDayOfWeekFont(new Font("SansSerif", Font.ITALIC, 12));
		calendar1.setDayFont(new Font("SansSerif", Font.BOLD, 16));
		calendar1.setTimeFont(new Font("DialogInput", Font.PLAIN, 10));
		calendar1.setTodayFont(new Font("Dialog", Font.PLAIN, 14));

		// Add all the calendars to the content pane

		JPanel panel1 = new JPanel(new FlowLayout());
		panel1.add(calendar1);
		contentPane.add(panel1);
		panel1.setBounds(0, 0, 261, 312);

		pack();
		this.setSize(275, 350);
		setVisible(true);
	}
	
	public Calendrier(final ListAppointmentView tbl){
		// Set up the frame

		setTitle("Calendrier");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		Container contentPane = getContentPane();
		contentPane.setLayout(null);

		// Create a border for all calendars

		Border etchedBorder =
				BorderFactory.createEtchedBorder();
		Border emptyBorder =
				BorderFactory.createEmptyBorder(10, 10, 10, 10);
		Border compoundBorder =
				BorderFactory.createCompoundBorder(etchedBorder, emptyBorder);

		// Display date and time using the default calendar and locale.
		// Display today's date at the bottom.

		JCalendar calendar1 =
				new JCalendar(
						JCalendar.DISPLAY_DATE | JCalendar.DISPLAY_TIME,
						true);
		calendar1.addDateListener(new DateListener(){
			public void dateChanged(DateEvent e)
			{
				Calendar c = e.getSelectedDate();
				if (c != null) {
					Calendrier.this.setVisible(false);
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					tbl.setDate(sdf.format(c.getTime()));
					System.out.println(sdf.format(c.getTime()));
				}
				else {
					System.out.println("No time selected.");
				}
			}
		});
		calendar1.setBorder(compoundBorder);

		// Set fonts rather than using defaults

		calendar1.setTitleFont(new Font("Serif", Font.BOLD|Font.ITALIC, 24));
		calendar1.setDayOfWeekFont(new Font("SansSerif", Font.ITALIC, 12));
		calendar1.setDayFont(new Font("SansSerif", Font.BOLD, 16));
		calendar1.setTimeFont(new Font("DialogInput", Font.PLAIN, 10));
		calendar1.setTodayFont(new Font("Dialog", Font.PLAIN, 14));

		// Add all the calendars to the content pane

		JPanel panel1 = new JPanel(new FlowLayout());
		panel1.add(calendar1);
		contentPane.add(panel1);
		panel1.setBounds(0, 0, 261, 312);

		pack();
		this.setSize(275, 350);
		setVisible(true);
		setLocationRelativeTo(null);
	}
}
