/*
* File   : $Source: /alkacon/cvs/opencms/src/com/opencms/core/Attic/I_CmsResponse.java,v $
* Date   : $Date: 2002/09/03 11:57:00 $
* Version: $Revision: 1.14 $
*
* This library is part of OpenCms -
* the Open Source Content Mananagement System
*
* Copyright (C) 2001  The OpenCms Group
*
* This library is free software; you can redistribute it and/or
* modify it under the terms of the GNU Lesser General Public
* License as published by the Free Software Foundation; either
* version 2.1 of the License, or (at your option) any later version.
*
* This library is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
* Lesser General Public License for more details.
*
* For further information about OpenCms, please see the
* OpenCms Website: http://www.opencms.org 
*
* You should have received a copy of the GNU Lesser General Public
* License along with this library; if not, write to the Free Software
* Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
*/

package com.opencms.core;

import java.io.*;

/**
 * This interface defines a CmsResponse.
 * 
 * The CmsResponse is a genereic response object that is used in the CmsObject provinding
 * methods to send data to the response.
 * 
 * Implementations of this interface use an existing responset (e.g. HttpServletResponse) to
 * initialize a CmsResponset. 
 * 
 * @author Michael Emmerich
 * @author Alexander Kandzior
 * @version $Revision: 1.14 $ $Date: 2002/09/03 11:57:00 $  
 */
public interface I_CmsResponse {
    
    /**
     * Returns the original response that was used to create the CmsResponse.
     * 
     * @return The original response of the CmsResponse.
     */
    public Object getOriginalResponse();
    
    /**
     * Returns the type of the response that was used to create the CmsResponse.
     * The returned int must be one of the constants defined above in this interface.
     * 
     * @return The type of the CmsResponse.
     */
    public int getOriginalResponseType();
    
    /**
     * Returns an OutputStream for writing the response data. 
     * 
     * @return OutputStream for writing data.
     * @exception Throws IOException if an error occurs.
     */
    public OutputStream getOutputStream() throws IOException;
    
    /**
     * Check if the output stream was requested previously.
     * @return <code>true</code> if getOutputStream() was called, <code>false</code> otherwise.
     */
    public boolean isOutputWritten();
    
    /**
     * Check if the current request was redirected. In this case, the
     * servlet must not write any bytes to the output stream.
     * @return <code>true</code> if the request is redirected, <code>false</code> otherwise.
     */
    public boolean isRedirected();
    
    /**
     * Sets a redirect to send the responst to. 
     * 
     * @param location The location the response is send to.
     * @param msg Additional error message.
     * @exception Throws IOException if an error occurs.
     */
    public void sendCmsRedirect(String location) throws IOException;
    
    /**
     * Sets the error code that is returnd by the response. The error code is specified
     * by a numeric value.
     * 
     * @param code The error code to be set.
     * @exception Throws IOException if an error occurs.
     */
    public void sendError(int code) throws IOException;
    
    /**
     * Sets the error code and a additional message that is returnd by the response. 
     * The error code is specified by a numeric value.
     * 
     * @param code The error code to be set.
     * @param msg Additional error message.
     * @exception Throws IOException if an error occurs.
     */
    public void sendError(int code, String msg) throws IOException;
    
    /**
     *  Helper function for a redirect to the cluster url. 
     * 
     * @param location a complete url, eg. http://servername/servlets/opencms/index.html 
     * @exception Throws IOException if an error occurs.
     */
    public void sendRedirect(String location) throws IOException;
    
    /**
     * Sets the length of the content being returned by the server.
     * 
     * @param len Number of bytes to be returned by the response.
     */
    public void setContentLength(int len);
    
    /**
     * Sets the content type of the response to the specified type.
     * 
     * @param type The contnent type of the response.
     */
    public void setContentType(String type);
    
    /**
     * Sets a header-field in the response.
     * 
     * @param key The key for the header.
     * @param value The value for the header.
     */
    public void setHeader(String key, String value);

    /**
     * Add a header-field in the response.
     * 
     * @param key The key for the header.
     * @param value The value for the header.
     */
    public void addHeader(String key, String value);
    
    /**
     * Sets the last modified header-field in the response.
     * 
     * @param time The last-modified time.
     */
    public void setLastModified(long time);
    
    /**
     * Checks, if the header was set already.
     * @param key, the header-key to check.
     * @return true, if the header was set before else false.
     */
    public boolean containsHeader(String key);
}
