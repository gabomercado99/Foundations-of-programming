

import grader.basics.execution.BasicProjectExecution;

import gradingTools.comp301ss21.assignment1_1.SS21Assignment1_1Suite;
import trace.grader.basics.GraderBasicsTraceUtility;
import util.trace.Tracer;

public class RunSummer21A1_1Tests {
	public static void main(String[] args) {
		// if you set this to false, grader steps will not be traced
		GraderBasicsTraceUtility.setTracerShowInfo(true);	
		// if you set this to false, all grader steps will be traced,
		// not just the ones that failed		
		GraderBasicsTraceUtility.setBufferTracedMessages(true);
		// Change this number if a test trace gets longer than 600 and is clipped
		GraderBasicsTraceUtility.setMaxPrintedTraces(600);
		// Change this number if all traces together are longer than 2000
		GraderBasicsTraceUtility.setMaxTraces(2000);
		// Change this number if your process times out prematurely
		BasicProjectExecution.setProcessTimeOut(5);
		// You need to always call such a method
		SS21Assignment1_1Suite.main(args);
	}
}

	


