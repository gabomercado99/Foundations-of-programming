package main;



import grader.basics.execution.BasicProjectExecution;




import gradingTools.comp301ss21.assignment4.SS21Assignment4Suite;
import trace.grader.basics.GraderBasicsTraceUtility;
import util.trace.Tracer;

public class RunSummer21A4Tests {
	static final int
			MAX_PRINT = 600,
			MAX_TRACE = 2000,
			TIME_OUT = 5;
	public static void main(String[] args) {
		// if you set this to false, grader steps will not be traced
		GraderBasicsTraceUtility.setTracerShowInfo(true);	
		// if you set this to false, all grader steps will be traced,
		// not just the ones that failed		
		GraderBasicsTraceUtility.setBufferTracedMessages(false);
		// Change this number if a test trace gets longer than 600 and is clipped
		GraderBasicsTraceUtility.setMaxPrintedTraces(MAX_PRINT);
		// Change this number if all traces together are longer than 2000
		GraderBasicsTraceUtility.setMaxTraces(MAX_TRACE);
		// Change this number if your process times out prematurely
		BasicProjectExecution.setProcessTimeOut(TIME_OUT);
		// You need to always call such a method
		SS21Assignment4Suite.main(args);
		}
	}
