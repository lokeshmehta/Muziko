// ------------------------------------------------------------------------------
// Copyright (c) 2015 Microsoft Corporation
//
// Permission is hereby granted, free of charge, to any person obtaining a copy
// of this software and associated documentation files (the "Software"), to deal
// in the Software without restriction, including without limitation the rights
// to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
// copies of the Software, and to permit persons to whom the Software is
// furnished to do so, subject to the following conditions:
//
// The above copyright notice and this permission notice shall be included in
// all copies or substantial portions of the Software.
//
// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
// IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
// FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
// AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
// LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
// OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
// THE SOFTWARE.
// ------------------------------------------------------------------------------

package com.onedrive.sdk.http;

import com.onedrive.sdk.logger.ILogger;
import com.onedrive.sdk.serializer.ISerializer;

/**
 * The handler interface for requests having stateful response from server.
 * The handler will custom the http connection if needed and generate request
 * result based on the server http response.
 *
 * @param <ResultType>       The result to return.
 * @param <DeserializedType> The deserialize type for serializer.
 */
public interface IStatefulResponseHandler<ResultType, DeserializedType> {
    /**
     * Configure the connection before get response.
     *
     * @param connection The http connection.
     */
    void configConnection(final IConnection connection);

    /**
     * Generate result after receiving response.
     *
     * @param request    The http request.
     * @param connection The http connection.
     * @param serializer The serializer for parsing response.
     * @param logger     The looger.
     * @return The result generated by this handler.
     * @throws Exception An exception occurs if the request was unable to complete for any reason.
     */
    ResultType generateResult(final IHttpRequest request,
                              final IConnection connection,
                              final ISerializer serializer,
                              final ILogger logger) throws Exception;
}
