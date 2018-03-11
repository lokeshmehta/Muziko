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

package com.onedrive.sdk.generated;

import com.onedrive.sdk.extensions.CreateLinkRequest;
import com.onedrive.sdk.extensions.ICreateLinkRequest;
import com.onedrive.sdk.extensions.IOneDriveClient;
import com.onedrive.sdk.http.BaseRequestBuilder;
import com.onedrive.sdk.options.Option;

import java.util.List;

// **NOTE** This file was generated by a tool and any changes will be overwritten.

/**
 * The class for the Base Create Link Request Builder.
 */
public class BaseCreateLinkRequestBuilder extends BaseRequestBuilder {

    public final String mType;

    /**
     * The request builder for this CreateLink
     *
     * @param requestUrl The request url
     * @param client     The service client
     * @param options    The options for this request
     */
    public BaseCreateLinkRequestBuilder(final String requestUrl, final IOneDriveClient client, final List<Option> options, final String type) {
        super(requestUrl, client, options);
        mType = type;
    }

    public ICreateLinkRequest buildRequest() {
        return buildRequest(getOptions());
    }

    public ICreateLinkRequest buildRequest(final List<Option> options) {
        return new CreateLinkRequest(getRequestUrl(), getClient(), options, mType);
    }
}