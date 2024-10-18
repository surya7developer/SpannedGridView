package com.suresh.spannedgridview.customview

/**
 * Exception thrown when the span size of the layout manager is 0 or negative
 */
class InvalidMaxSpansException(maxSpanSize: Int) :
        RuntimeException("Invalid layout spans: $maxSpanSize. Span size must be at least 1.")