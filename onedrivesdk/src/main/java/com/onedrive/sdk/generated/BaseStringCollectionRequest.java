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

// **NOTE** This file was generated by a tool and any changes will be overwritten.
package com.onedrive.sdk.generated;

import com.onedrive.sdk.extensions.IOneDriveClient;
import com.onedrive.sdk.extensions.IStringCollectionPage;
import com.onedrive.sdk.extensions.IStringCollectionRequest;
import com.onedrive.sdk.extensions.IStringCollectionRequestBuilder;
import com.onedrive.sdk.extensions.StringCollectionPage;
import com.onedrive.sdk.extensions.StringCollectionRequest;
import com.onedrive.sdk.extensions.StringCollectionRequestBuilder;
import com.onedrive.sdk.http.BaseCollectionRequest;
import com.onedrive.sdk.options.Option;
import com.onedrive.sdk.options.QueryOption;

import java.util.List;

// **NOTE** This file was generated by a tool and any changes will be overwritten.

/**
 * The class for the Base String Collection Request.
 */
public class BaseStringCollectionRequest extends BaseCollectionRequest<BaseStringCollectionResponse, IStringCollectionPage> implements IBaseStringCollectionRequest {

    /**
     * The request builder for this collection of String
     *
     * @param requestUrl The request url
     * @param client     The service client
     * @param options    The options for this request
     */
    public BaseStringCollectionRequest(final String requestUrl, IOneDriveClient client, final List<Option> options) {
        super(requestUrl, client, options, BaseStringCollectionResponse.class, IStringCollectionPage.class);
    }

    public IStringCollectionRequest expand(final String value) {
        addQueryOption(new QueryOption("expand", value));
        return (StringCollectionRequest) this;
    }

    public IStringCollectionRequest select(final String value) {
        addQueryOption(new QueryOption("select", value));
        return (StringCollectionRequest) this;
    }

    public IStringCollectionRequest top(final int value) {
        addQueryOption(new QueryOption("top", value + ""));
        return (StringCollectionRequest) this;
    }

    public IStringCollectionPage buildFromResponse(final BaseStringCollectionResponse response) {
        final IStringCollectionRequestBuilder builder;
        if (response.nextLink != null) {
            builder = new StringCollectionRequestBuilder(response.nextLink, getBaseRequest().getClient(), /* options */ null);
        } else {
            builder = null;
        }
        final StringCollectionPage page = new StringCollectionPage(response, builder);
        page.setRawObject(response.getSerializer(), response.getRawObject());
        return page;
    }
}
